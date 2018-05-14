package ru.job4j.strategy;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Класс PaintTest.
 *@author ifedorenko
 *@since 26.08.2017
 *@version 1
 */
 public class PaintTest {
    /**
     * Triangle 3.
     */
     @Test
     public void whenTriangleWithHeightThreeThenStringWithThreeRows() {
         ByteArrayOutputStream out = new ByteArrayOutputStream();
         System.setOut(new PrintStream(out));
		 Paint paint = new Paint();
		 paint.draw(new Triangle(3));
         final String line = System.getProperty("line.separator");
         String expected = String.format("  x%s x x%sxxxxx%s%s", line, line, line, line);
         assertThat(out.toString(), is(expected));
	 }
    /**
     * Square 4 x 4.
     */
	 @Test
      public void whenPaintSquareWithWidthFourThenStringWithFourColsAndFourRows() {
         ByteArrayOutputStream out = new ByteArrayOutputStream();
         System.setOut(new PrintStream(out));
         Paint paint = new Paint();
         paint.draw(new Square(4));
         final String line = System.getProperty("line.separator");
         String expected = String.format("xxxx%sx  x%sx  x%sxxxx%s%s", line, line, line, line, line);
         assertThat(out.toString(), is(expected));
    }
 }