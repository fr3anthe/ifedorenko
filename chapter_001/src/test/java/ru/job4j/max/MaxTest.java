package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
* @author Igor Fedorenko (mailto:if.zommy@gmail.com)
* @version $Id$
* @since 0.1
*/
public class MaxTest {
	/**
	 * Test first less second.
	 */
	@Test
	public void whenFirstLessSecond() {
		Max maxim = new Max();
		int result = maxim.max(1, 2);
		assertThat(result, is(2));
	}
	/**
	 * Test first more second.
	 */
	@Test
	public void whenFirstMoreSecond() {
		Max maxim = new Max();
		int result = maxim.max(3, 2);
		assertThat(result, is(3));
	}
	/**
	 * Test first equal second.
	 */
	@Test
	public void whenFirstEqualSecond() {
		Max maxim = new Max();
		int result = maxim.max(1, 1);
		assertThat(result, is(1));
	}
}