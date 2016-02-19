package fi.arcusys.lr7.chuckimpl;

import fi.arcusys.lr7.chuckapi.ChuckFacts;
import org.osgi.service.component.annotations.Component;

import java.util.Random;

/**
 * The @Component annotation indicates that your class defines a
 * Declarative Services component. The service = ChuckFacts.class
 * line indicates that your class will be registered under the
 * ChuckFacts interface.
 */
@Component(
    immediate = true,
    property = {
    },
    service = ChuckFacts.class
)
public class ChuckFactsImpl implements ChuckFacts {
    public static final String[] FACTS = {
        "If, by some incredible space-time paradox, Chuck Norris would ever fight himself, he'd win. Period.",
        "Chuck Norris doesn't step on toes. Chuck Norris steps on necks.",
        "There is no such thing as global warming. Chuck Norris was cold, so he turned the sun up.",
        "Chuck Norris did in fact, build Rome in a day.",
        "When Chuck Norris says \"More cowbell\", he MEANS it.",
        "Chuck Norris can judge a book by its cover.",
        "When Bruce Banner gets mad, he turns into the Hulk. When the Hulk gets mad, he turns into Chuck Norris.",
        "Everybody loves Raymond. Except Chuck Norris.",
        "The boogie man checks his closet at night for Chuck Norris."
    };

    @Override
    public String getRandomQuote() {
        return FACTS[new Random().nextInt(FACTS.length)];
    }

}