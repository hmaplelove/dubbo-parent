package com.hmaplelove.apps.test;

import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

public class ZooKeeperTest {
	@Test
	public void zooKeeper() throws Exception {
		ZooKeeper zk = new ZooKeeper("localhost:10181",5000000, new Watcher() { 
            // 监控所有被触发的事件
            public void process(WatchedEvent event) { 
                System.out.println("已经触发了" + event.getType() + "事件！"); 
            } 
        });
		
		System.out.println(zk.getState().toString());
		String root="/dubbo-demo";
		Stat stat=zk.exists(root, true);
		if ( stat == null) {
			String path =zk.create(root,"root".getBytes(),Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			System.err.println(path);
		}
		System.err.println(stat);
		// 将server的地址数据关联到新创建的子节点上  
       /* String createdPath = zk.create(root+"/node", "http://xxx.xx.com/api/v2.0/getUser".getBytes("utf-8"),   
            Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);  
        System.out.println("create: " + createdPath);
       */ 
        
        List<String> childrens=zk.getChildren(root, true);
        System.out.println(childrens);
        System.in.read();
        
	}
}
