package eci.edu.arsw.blacklistvalidator;

import java.util.*;

import eci.edu.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class FinderSeg extends Thread {
    private int startIndex;
    private int endIndex;

    private String ip;
    
    private HostBlacklistsDataSourceFacade data;


    private List<Integer> servers = new ArrayList<>();

    public FinderSeg(int start, int end, String ip, HostBlacklistsDataSourceFacade data) {
        startIndex = start;
        endIndex = end;
        this.ip = ip;
        this.data = data;
    }


    public void run(){
        for (int i = startIndex; i < endIndex; i++){
            if(data.isInBlackListServer(i, ip)){
                servers.add(i);
            }
        }
    }


    public List<Integer> getServers(){
        return servers;
    }


    public int getServersSize(){
        return servers.size();
    }

    public int getStart(){
        return startIndex;
    }

    public int getEnd(){
        return endIndex; 
    }
}
