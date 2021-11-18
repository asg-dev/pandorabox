package support;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class PiStresser {
        private final long requestedThreads;

	private final long requestesIterations;


	public PiStresser(long requestedThreads, long requestesIterations) {

		this.requestedThreads = requestedThreads;

		this.requestesIterations = requestesIterations;

	}



	public void start() throws InterruptedException {

		List<PiThread> threads = new ArrayList<PiThread>();

		for (int i = 0; i < requestedThreads; i++) {

			threads.add(new PiThread(requestesIterations));
        }


		for (PiThread thread : threads) {
            thread.start();
        }



		while (!allThreadsEnded(threads)) {
            Thread.sleep(10);
        }

	}



	private boolean allThreadsEnded(List<PiThread> threads) {

		for (PiThread thread : threads) {

			if (!thread.hasEnded()) {
                return false;
            }

	}


	return true;
    }
}
