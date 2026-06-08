package CoreJava;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Cricket annotation is used to provide metadata about a cricketer.
 *
 * <p>This annotation can be applied on:
 * <ul>
 *     <li>Classes (TYPE)</li>
 *     <li>Fields (FIELD)</li>
 * </ul>
 *
 * <p>The annotation information is retained at runtime,
 * allowing it to be accessed using Reflection APIs.
 *
 * Example:
 *
 * <pre>
 * {@code
 * @Cricket(age = 35)
 * class ViratKohli {
 * }
 * }
 * </pre>
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface Cricket {

    /**
     * Returns the country of the cricketer.
     *
     * <p>Default value is "India".
     *
     * @return country name
     */
    String country() default "India";

    /**
     * Returns the age of the cricketer.
     *
     * <p>This attribute is mandatory while using
     * the annotation because no default value is provided.
     *
     * @return age of the cricketer
     */
    int age();
}

/**
 * Represents Virat Kohli, an Indian cricketer.
 *
 * <p>The {@link Cricket} annotation provides
 * metadata about the cricketer.
 */
@Cricket(age = 35)
class ViratKohli {

    /**
     * Age of Virat Kohli.
     */
    @Cricket(age = 35)
    int age;

    /**
     * Batting average.
     */
    double avg;

    /**
     * Creates a ViratKohli object.
     *
     * @param age age of the cricketer
     * @param avg batting average
     */
    public ViratKohli(int age, double avg) {
        this.age = age;
        this.avg = avg;
    }

    /**
     * Returns batting average.
     *
     * @return batting average
     */
    public double getAvg() {
        return avg;
    }

    /**
     * Returns age.
     *
     * @return age
     */
    public int getAge() {
        return age;
    }
}

/**
 * Demonstrates creation and usage of custom annotations.
 *
 * <p>The program:
 * <ol>
 *     <li>Creates a ViratKohli object.</li>
 *     <li>Retrieves annotation metadata using Reflection.</li>
 *     <li>Prints annotation values.</li>
 * </ol>
 */
public class Annotations {

    /**
     * Entry point of the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        ViratKohli vk = new ViratKohli(35, 88.8);

        System.out.println(vk.getAge());

        // Get runtime class information
        Class<? extends ViratKohli> c = vk.getClass();

        // Read annotation using Reflection
        Cricket cp = c.getAnnotation(Cricket.class);

        int age = cp.age();
        String country = cp.country();

        System.out.println("Age: " + age);
        System.out.println("Country: " + country);
    }
}