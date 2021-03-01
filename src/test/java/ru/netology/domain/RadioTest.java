package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    @Test
    void testNumberChannelRadioFAIL() {
        int actualChannel = -2;
        int actualSoundLevel = 4;
        String actualMessage = null;

        try {
            new Radio(actualChannel, actualSoundLevel);
        } catch (IllegalArgumentException ex1 ) {
            actualMessage = ex1.getMessage();
        }

        String expectedMessage1 = "Ошибка в Radio::Radio(int numberRadio, int soundLevel). Некорректный канал: " + actualChannel;
        assertEquals(expectedMessage1, actualMessage);
    }

    @Test
    void testSoundLevelRadioFAIL(){
        int actualChannel = 2;
        int actualSoundLevel = -4;
        String actualMessage = null;

        try {
            new Radio(actualChannel, actualSoundLevel);
        } catch (IllegalArgumentException ex1 ) {
            actualMessage = ex1.getMessage();
        }

        String expectedMessage = "Ошибка в Radio::Radio(int numberRadio, int soundLevel). Некорректный уровень громкости: " + actualSoundLevel;
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testChannelAndSoundLevelRadioOk() {
        int actualChannel = 2;
        int actualSoundLevel = 4;

        Radio radio = new Radio(actualChannel, actualSoundLevel);

        int newActualChannel = radio.getNumberRadio();
        int newActualSoundLevel = radio.getSoundLevel();

        assertEquals(2, newActualChannel);
        assertEquals(4, newActualSoundLevel);
    }

    @Test
    void testSetNumberRadioFAIL() {
        int intitialActualNumberRadio = 6;
        int actualLevelSound = 9;
        int newActualNumberRadio = -5;

        String actualMessage = null;

        try {
            Radio radio = new Radio(intitialActualNumberRadio, actualLevelSound);
            radio.setNumberRadio(newActualNumberRadio);
        } catch (IllegalArgumentException ex) {
            actualMessage = ex.getMessage();
        }

        String expectedMessage = "Ошибка в Radio::setNumberRadio. Некорректный канал: " + newActualNumberRadio;
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetNumberChanelRadioOK() {
        int intitialActualNumberRadio = 3;
        int actualLevelSound = 9;
        int newActualNumberRadio = 8;

        Radio radio = new Radio(intitialActualNumberRadio, actualLevelSound);
        radio.setNumberRadio(newActualNumberRadio);

        int currentNumberRadio = radio.getNumberRadio();
        assertEquals(newActualNumberRadio, currentNumberRadio);
    }

    @Test
    void testSetLevelSoundRadioFAIL() {
        int actualNumberRadio = 4;
        int initialLevelSound = 1;
        int newActualLevelSound = 120;
        String actualMessage = null;

        try {
            Radio radio = new Radio(actualNumberRadio, initialLevelSound);
            radio.setSoundLevel(newActualLevelSound);
        } catch (IllegalArgumentException ex){
            actualMessage = ex.getMessage();
        }

        String expectedMessage = "Ошибка в Radio::setSoundLevel. Некорректный уровень громкости: " + newActualLevelSound;
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetLevelSoundRadioOK() {
        int actualNumberRadio = 4;
        int initialLevelSound = 1;
        int newActualLevelSound = 5;

        Radio radio = new Radio(actualNumberRadio, initialLevelSound);
        radio.setSoundLevel(newActualLevelSound);

        int currentLevelSound = radio.getSoundLevel();
        assertEquals(newActualLevelSound, currentLevelSound);
    }

    @Test
    void tesChannelNext9_OK() {
        int actualNumberRadio = 10;
        int actualLevelSound = 10;

        Radio radio = new  Radio(actualNumberRadio, actualLevelSound);
        int newActualChannal = radio.next();

        assertEquals(0, newActualChannal);
    }

    @Test
    void testChannelNext4_OK() {
        int actualNumberRadio = 4;
        int actualLevelSound = 10;

        Radio radio = new  Radio(actualNumberRadio, actualLevelSound);
        int newActualChannal = radio.next();

        assertEquals(5, newActualChannal);
    }

    @Test
    void testChannelNext25_FAIL() {
        int actualNumberRadio = 25;
        int actualLevelSound = 10;

        String actualMessege = null;

        try {
            Radio radio = new  Radio(actualNumberRadio, actualLevelSound);
            radio.next();
        } catch (IllegalArgumentException ex){
            actualMessege = ex.getMessage();
        }

        String expectedMessege = "Ошибка в Radio::Radio(int numberRadio, int soundLevel). Некорректный канал: " + actualNumberRadio;
        assertEquals(expectedMessege, actualMessege);
    }

    @Test
    void testChannelPrev0_OK() {
        int actualNumberRadio = 0;
        int actualLevelSound = 10;

        Radio radio = new  Radio(actualNumberRadio, actualLevelSound);
        int newActualChannal = radio.prev();

        assertEquals(10, newActualChannal);
    }

    @Test
    void testChannelPrev7_OK() {
        int actualNumberRadio = 7;
        int actualLevelSound = 10;

        Radio radio = new  Radio(actualNumberRadio, actualLevelSound);
        int newActualChannal = radio.prev();

        assertEquals(6, newActualChannal);
    }

    @Test
    void testSoundLevelPlus10_OK(){
        int actualNumberRadio = 3;
        int actualLevelSound = 100;
        Radio radio = new  Radio(actualNumberRadio, actualLevelSound);
        int newActualLevelSound = radio.plusSound();

        assertEquals(100, newActualLevelSound);
    }

    @Test
    void testSoundLevelPlus6_OK(){
        int actualNumberRadio = 3;
        int actualLevelSound = 6;
        Radio radio = new  Radio(actualNumberRadio, actualLevelSound);
        int newActualLevelSound = radio.plusSound();

        assertEquals(7, newActualLevelSound);
    }

    @Test
    void testChannelPlus27_FAIL(){
        int actualNumberRadio = 3;
        int actualLevelSound = 135;
        String actualMessege = null;

        try {
            Radio radio = new  Radio(actualNumberRadio, actualLevelSound);
            radio.plusSound();
        } catch (IllegalArgumentException ex){
            actualMessege = ex.getMessage();
        }

        String expectedMessege = "Ошибка в Radio::Radio(int numberRadio, int soundLevel). Некорректный уровень громкости: " + actualLevelSound;
        assertEquals(expectedMessege, actualMessege);
    }

    @Test
    void testLevelSoundMinus0_OK(){
        int actualNumberRadio = 3;
        int actualLevelSound = 0;

        Radio radio = new  Radio(actualNumberRadio, actualLevelSound);
        int newActualLevelSound = radio.minusSound();

        assertEquals(0, newActualLevelSound);
    }

    @Test
    void testLevelSoundMinus5_OK(){
        int actualNumberRadio = 3;
        int actualLevelSound = 5;

        Radio radio = new  Radio(actualNumberRadio, actualLevelSound);
        int newActualLevelSound = radio.minusSound();

        assertEquals(4, newActualLevelSound);
    }


    @Test
    void testSoundLevelAndGetterOK() {
        int actualNumberRadio = 3;
        int actualLevelSound = 4;

        Radio radio = new  Radio(actualNumberRadio, actualLevelSound);
        int newActualNumberRadio = radio.getNumberRadio();
        int newActualLevelSound = radio.getSoundLevel();

        assertEquals(3, newActualNumberRadio);
        assertEquals(4, newActualLevelSound);

    }
}