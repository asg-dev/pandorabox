package support;

import java.security.InvalidParameterException;
/**
 *
 * @author User
 */
public class ArgumentsMapper {
    public static final String T_THREADS = "-t";
    public static final String I_ITERATIONS = "-i";

    public static final int DEFAULT_THREADS = 32;
    public static final int DEFAULT_ITERATIONS = 100;
    /*  Typically 1000000000, but keeping it to 100
        to ensure quick working times */

    public Arguments map() {
        return new Arguments(DEFAULT_THREADS, DEFAULT_ITERATIONS);
    }
}
