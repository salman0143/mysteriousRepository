package com.abyat.mvp.main;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.abyat.mvp.model.PlayerMatchStats;
import com.abyat.mvp.model.impl.Basketball;
import com.abyat.mvp.model.impl.Handball;
import com.abyat.mvp.reader.StatsReader;
import com.abyat.mvp.util.MVPUtil;

/**
 * MVP application entry point.
 *
 * @author Salman Khan
 */
public class MVPMain {

	public static final Map<String, Class> SPORTS = new HashMap<>();

	// add more implementations to support more sports
	static {
		SPORTS.put("BASKETBALL", Basketball.class);
		SPORTS.put("HANDBALL", Handball.class);
	}

	public static void main(String[] args) throws Exception {

		// put your fileset path or user command line argument
		String filePath = "C:/Users/SALMAN TYAGI/abyat";

		File fileSet = new File(filePath);

		List<PlayerMatchStats> playerMatchStatsList = new ArrayList<>();

		// read all match files and add appropriate stats
		for (File file : fileSet.listFiles()) {
			playerMatchStatsList.addAll(StatsReader.readMatchStats(new FileInputStream(file)));
		}

		// get our MVP nickname
		System.out.println("MVP Nickname: " + MVPUtil.getMVPNick(playerMatchStatsList));
	}

}
