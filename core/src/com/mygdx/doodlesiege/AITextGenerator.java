package com.mygdx.doodlesiege;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AITextGenerator {

    public static String prompt(String input) {
        input = input.replace(" ","-");
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://contentai-net-text-generation.p.rapidapi.com/v1/text/blog-articles?category="+input))
                    .header("X-RapidAPI-Key", "a9404f993fmshee7db5a6f31bfd1p15a3cajsn95f5dc36985e")
                    .header("X-RapidAPI-Host", "contentai-net-text-generation.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            String patternString = "\"suggestedTitle\":\"(.*?)\"";
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(response.body());
            if (matcher.find()) {
                String suggestedTitle = matcher.group(1);
                String[] words = suggestedTitle.split(" ");
                suggestedTitle = "";
                for(int i=0; i<words.length; i+=5){
                    try {
                        suggestedTitle += words[i] + " ";
                        suggestedTitle += words[i + 1] + " ";
                        suggestedTitle += words[i + 2] + " ";
                        suggestedTitle += words[i + 3] + " ";
                        suggestedTitle += words[i + 4] + "\n";
                    }catch (IndexOutOfBoundsException e){
                        continue;
                    }
                }
                return suggestedTitle;
            } else {
                return "the hero vs ghosts";
            }

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}


