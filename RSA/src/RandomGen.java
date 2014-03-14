import java.math.BigInteger;
import java.util.Random;

import RSABigInteger.RSABigInteger;


public class RandomGen {
	
	/**
	 * Randomly generates an exponent with a given size.
	 * @param size the size of the exponent
	 * @return the exponent which is an RSABigInteger
	 */
	public RSABigInteger getRandExp(int size){

		BigInteger 	p, q, phiN;
		RSABigInteger e;
		
		//Two prime numbers q and p are randomly chosen
		q = new BigInteger(size/2, 15, new Random());
		p = new BigInteger(size/2, 15, new Random());
		
		//phiN is calculated such as phiN=(p-1).(q-1)
		phiN = p.subtract(BigInteger.ONE);
		phiN = phiN.multiply(q.subtract(BigInteger.ONE));
		
		//A random e exponent is calculated such that 
		do{
			e = new RSABigInteger(size, new Random());
		}while(e.compareTo(phiN)!=1 || e.gcd(phiN).compareTo(BigInteger.ONE)!=0);
	
		return e;
	}
	
	/**
	 * Generate an {@link RSABigInteger} with a given size and a random value
	 * @param size the bit size of the value
	 * @return
	 */
	public RSABigInteger getRandInput(int size){
		RSABigInteger result = new RSABigInteger(size, new Random());
		return result;
	}
}