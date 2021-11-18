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
public class PiThread extends Thread {
    private final long iterations;

	private final PiCalculator calculator;


	private boolean ended = false;



	public PiThread(long iterations) {

		this.iterations = iterations;

		this.calculator = new PiCalculator();

	}



	@Override
    public void run() {

		calculator.gaussLegendre(iterations);

		ended = true;

	}



	public boolean hasEnded() {

		return ended;

	}
}
