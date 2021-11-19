package org.example.config;

import org.example.qualifier.GuessCount;
import org.example.qualifier.MaxNumber;
import org.example.qualifier.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {
    // == fields ==
    @Value("${game.maxNumber}")
    private int maxNumber;

    @Value("${game.guessCount:5}") // 5 is the default value if the property cannot be found
    private int guessCount;

    @Value("${game.minNumber:0}")
    private int minNumber;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber() { // with qualifiers annotated here and on the autowired target, this method can have any name (otherwise it would need to have the same name as the components being autowired
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }
}
