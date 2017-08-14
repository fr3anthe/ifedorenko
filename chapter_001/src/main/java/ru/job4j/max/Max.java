package ru.job4j.max;
/**
 *Класс помогает узнать, какое из двух чисел больше.
 *@author ifedorenko
 *@since 14.08.2017
 *@version 1
 */
public class Max {
	/**
	*Возвращает большее число.
	*@param first содержит первое число
	*@param second содержит второе число
	*@return Большее число
	*/
	public int max(int first, int second) {
		return first > second ? first : second;
	}
}