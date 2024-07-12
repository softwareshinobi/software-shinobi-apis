package digital.softwareshinobi.workspace.articlemagick;

import digital.softwareshinobi.workspace.articlemagick.SpecialTextFormattingUtility;
import digital.softwareshinobi.workspace.articlemagick.TextWorkerUtility;
import java.util.Map;
import java.util.regex.Pattern;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("")
public class ArticleMagickController {

    public ArticleMagickController() {

        System.out.println();
        System.out.println("##");
        System.out.println("## init > Article Magick Controller");
        System.out.println("##");
        System.out.println();

    }

    @GetMapping("")
    public String landing1() {

        return "Article Magick API";

    }

    @GetMapping("/")
    public String landing2() {

        return "Article Magick API";

    }

    @GetMapping("/health")
    public String health() {

        return "OK";

    }

    @PostMapping("/simple-format")
    public String simpleTextFormat(@RequestBody Map requestPayLoad) {

        System.out.println("enter > simpleTextFormat()");

        System.out.println("requestPayLoad / " + requestPayLoad);

        String dirtyText = requestPayLoad.get("originalContent").toString();

        System.out.println("content / original / " + dirtyText);

        String cleanText = SpecialTextFormattingUtility.cleanAndFormatText(dirtyText);

        cleanText = cleanText.replaceAll("\\?\\.", "?").trim();

        System.out.println("return / " + cleanText);

        System.out.println("exit < simpleTextFormat()");

        return cleanText;

    }

    @PostMapping("/calculate-similarity")
    public Double calculateTextSimilarityPercentage(@RequestBody Map requestPayLoad) {

        System.out.println("enter > calculateTextSimilarityPercentage()");

        System.out.println("requestPayLoad / " + requestPayLoad);

        String originalContent = requestPayLoad.get("originalContent").toString()
                .toLowerCase().replaceAll("\\n+", " ").replaceAll("\\s+", " ").trim();

        System.out.println("content / original / " + originalContent);

        String rewrittenContent = requestPayLoad.get("rewrittenContent").toString()
                .toLowerCase().replaceAll("\\n+", " ").replaceAll("\\s+", " ").trim();

        System.out.println("content / rewrite / " + rewrittenContent);

        Double textSimilarityPercentage = TextWorkerUtility.calculateTextSimilarityPercentage(
                originalContent,
                rewrittenContent
        );

        System.out.println("return / " + textSimilarityPercentage);

        System.out.println("exit < calculateTextSimilarityPercentage()");

        return textSimilarityPercentage;

    }

    @PostMapping("/convert-sentence-to-permalink")
    public String convertToPermalink(@RequestBody final String textToConvert) {

        System.out.println("enter > convert-sentence-to-permalink");

        System.out.println("textToConvert / " + textToConvert);

        String formattedTextContent = textToConvert.toLowerCase().trim().replaceAll("[\\n\\s]+", "-");

        formattedTextContent = formattedTextContent.replaceAll("\\?\\.", "?").trim();

        return formattedTextContent;

    }

    @PostMapping("/convert-permalink-to-sentence")
    public String convertFromPermalink(@RequestBody final String textToConvert) {

        System.out.println("enter > convert-permalink-to-sentence");

        System.out.println("textToConvert / " + textToConvert);

        final Pattern WORD_SEPARATOR_PATTERN = Pattern.compile("-|\\s+");

        StringBuilder sentence = new StringBuilder();

        boolean capitalizeNext = true;

        for (String word : WORD_SEPARATOR_PATTERN.split(textToConvert)) {

            if (capitalizeNext) {

                sentence.append(Character.toUpperCase(word.charAt(0)));

                sentence.append(word.substring(1));

            } else {

                sentence.append(word);

            }

            sentence.append(" ");

            capitalizeNext = false;

        }

        return sentence.toString().trim();

    }

}
