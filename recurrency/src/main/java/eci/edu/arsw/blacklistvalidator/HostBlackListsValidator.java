package eci.edu.arsw.blacklistvalidator;

import java.util.*;
import java.util.logging.*;

import eci.edu.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class HostBlackListsValidator {

    private static final int BLACK_LIST_ALARM_COUNT = 5;

    public List<Integer> checkHost(String ipaddress, int threads) {

        HostBlacklistsDataSourceFacade skds = HostBlacklistsDataSourceFacade.getInstance();
        int totalServers = skds.getRegisteredServersCount();
        int divide = totalServers / threads;
        List<FinderSeg> finders = new ArrayList<>();

        for (int i = 0; i < threads; i++) {
            int start = i * divide;

            int end;
            if (i == threads - 1) {
                end = totalServers;
            } else {
                end = start + divide;
            }

            FinderSeg finderSeg = new FinderSeg(start, end, ipaddress, skds);
            finderSeg.start();
            finders.add(finderSeg);
        }

        List<Integer> blackList = new ArrayList<>();
        int checkedLists = 0;

        for (FinderSeg t : finders) {
            try {
                t.join();
                blackList.addAll(t.getServers());
                checkedLists += (t.getEnd() - t.getStart());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (blackList.size() >= BLACK_LIST_ALARM_COUNT) {
            skds.reportAsNotTrustworthy(ipaddress);
            LOG.log(Level.INFO, "HOST {0} Reported as NOT trustworthy", ipaddress);
        } else {
            skds.reportAsTrustworthy(ipaddress);
            LOG.log(Level.INFO, "HOST {0} Reported as trustworthy", ipaddress);
        }

        LOG.log(Level.INFO, "Checked Black Lists:{0} of {1}",
                new Object[] { totalServers, skds.getRegisteredServersCount() });

        return blackList;
    }

    private static final Logger LOG = Logger.getLogger(HostBlackListsValidator.class.getName());

}
