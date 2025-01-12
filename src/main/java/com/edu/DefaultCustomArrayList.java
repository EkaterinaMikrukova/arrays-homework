package com.edu;

import java.util.Iterator;

public class DefaultCustomArrayList<E> implements CustomArrayList<E> {
    E [] array;
    int size = 0; // хочу сделать с одной перемнной и не увеличивать массив *2, каждый раз добавлять по мере надобности 1 элемент

    public DefaultCustomArrayList() {
        array = (E[]) new Object [size];
    }

    @Override
    public boolean add(E element) {
        size++;
        if (size > array.length){
            array = Arrays.copyof(array, size); // работает такое расширение массива на +1 без создания временного массива. способ оч простой 
        }
        array [array.length -1] = element; // присваиваем последний элемент расширенного массива 
        return true;
    }

    @Override
    public boolean remove(E element) {
        // ищем элемент
        for (int i = 0; i < array.length; i++) {
            if (array [i].equals(element)) {
                // после того как нашли "сдвигаем" массив, затирая найденный элемент
                for (int j = i + 1; j < array.length; j++) {
                    array [i] = array [j];
                }
                array = Arrays.copyof(array, array.length - 1); // образаем массив на 1
                return true;
            }
        }
        return false;
    }

    private void remove(int index) {
        // проверяем диапазон индекса
        if (index >= 0 && index < aray.length) {
            for (int i = index; i < array.length - 1; i++) {
                // аналогично переписываем массив затирая индексный элемнт
                array [i] = array [i + 1];
            }
            array = arrays.copyof(array, array.length - 1); // обрезаем массив на 1
        }
    } // на заметку. Тест пройден без написания этого метода

    @Override
    public E get(int index) {
        return array[index]; // тест пройден без проверки на выход из диапазона 
    }

    @Override
    public int size() {
        return array.length; 
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public void clear() {
        array = (E[]) new Object [0]; // инициализируем пустой массив, без заморочек
    }

    @Override
    public boolean contains(E element) {
        for (E s : array) {
            if (s.equals(element)) 
                return true;
        }
        return false;
    }

    @Override // все тесты пройдены кроме этого. Непонятно что нужно реализовать
    public Iterator<E> iterator() {
        return null;
    }
}
