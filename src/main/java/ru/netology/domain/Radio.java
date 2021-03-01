package ru.netology.domain;

public class Radio {
    private static final int CHANNEL_MAX = 10;
    private static final int CHANNEL_MIN = 0;
    private static final int LEVEL_MAX = 100;
    private static final int LEVEL_MIN = 0;

    private int numberRadio;
    private int soundLevel;

    public Radio(int numberRadio, int soundLevel) {
        if ((numberRadio < CHANNEL_MIN || numberRadio > CHANNEL_MAX)) {
            throw new IllegalArgumentException("Ошибка в Radio::Radio(int numberRadio, int soundLevel). Некорректный канал: " + numberRadio);
        } else if (soundLevel < LEVEL_MIN || soundLevel > LEVEL_MAX) {
            throw new IllegalArgumentException("Ошибка в Radio::Radio(int numberRadio, int soundLevel). Некорректный уровень громкости: " + soundLevel);
        } else {
            this.soundLevel = soundLevel;
            this.numberRadio = numberRadio;
        }
    }

    public int getNumberRadio() {
        return numberRadio;
    }

    public int getSoundLevel() {
        return soundLevel;
    }

    public void setNumberRadio(int numberRadio) {
        if (numberRadio < LEVEL_MIN || numberRadio > LEVEL_MAX) {
            throw new IllegalArgumentException("Ошибка в Radio::setNumberRadio. Некорректный канал: " + numberRadio);
        } else {
            this.numberRadio = numberRadio;
        }
    }

    public void setSoundLevel(int soundLevel) {
        if (soundLevel < LEVEL_MIN || soundLevel > LEVEL_MAX) {
            throw new IllegalArgumentException("Ошибка в Radio::setSoundLevel. Некорректный уровень громкости: " + soundLevel);
        } else {
            this.soundLevel = soundLevel;
        }
    }

    public int next() {
        if (numberRadio == CHANNEL_MAX) {
            numberRadio = CHANNEL_MIN;
        } else {
            numberRadio = numberRadio + 1;
        }
        return numberRadio;
    }

    public int prev() {
        if (numberRadio == CHANNEL_MIN) {
            numberRadio = CHANNEL_MAX;
        } else {
            numberRadio = numberRadio - 1;
        }
        return numberRadio;
    }

    public int plusSound() {
        if (soundLevel == LEVEL_MAX) {
            soundLevel = LEVEL_MAX;
        } else {
            soundLevel++;
        }
        return soundLevel;
    }

    public int minusSound() {
        if (soundLevel == LEVEL_MIN) {
            soundLevel = LEVEL_MIN;
        } else {
            soundLevel--;
        }
        return soundLevel;
    }

}
