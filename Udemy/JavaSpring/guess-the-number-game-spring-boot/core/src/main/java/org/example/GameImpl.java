package org.example;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.qualifier.GuessCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j // automatically adds 'private static final Logger log'
@Getter
@Component("gamer") // we can specify the name of our component like this if necessary
public class GameImpl implements Game {

    // == fields ==
    private final int guessCount;
    private int number;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Getter(AccessLevel.NONE) // this annotation avoids generating the getter for this field
    private final NumberGenerator numberGenerator;

    @Setter
    private int guess;

    // == constructor ==
    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    // == init method ==
    @PostConstruct
    @Override
    public void reset() {
        guess = 0;
        remainingGuesses = guessCount;
        smallest = numberGenerator.getMinNumber();
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("Game initialized. The number is {}", number);
    }

    @PreDestroy
    public void preDestroy() {
        log.debug("Game is being destroyed");
    }

    // == public methods ==
    @Override
    public void check() {
        checkValidNumberRange();

        if (validNumberRange) {
            if (guess > number) {
                biggest = guess - 1;
            }

            if (guess < number) {
                smallest = guess + 1;
            }
        }

        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == private methods ==
    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);

    }
}