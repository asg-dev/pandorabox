package support;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author User
 */
public class Arguments {
    private final long threads;

private final long iterations;


	public Arguments(long threads, long iterations) {

		this.threads = threads;

		this.iterations = iterations;
		}


	public long getThreads() {

		return threads;

		}


	public long getIterations() {

	return iterations;

	}
}
