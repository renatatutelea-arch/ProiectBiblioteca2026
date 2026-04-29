package main.java.com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.carte;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IsbnLookupService {

    private final RestTemplate rest = new RestTemplate();

    public carte lookup(String isbn) {
        // 1. Scoatem cratimele si spatiile (ex: "978-973-46-7234-5" -> "9789734672345")
        String cleanIsbn = isbn.replaceAll("[-\\s]", "");

        // 2. Apelam Google Books
        String url = "https://www.googleapis.com/books/v1/volumes?q=isbn:" + cleanIsbn;
        JsonNode raspuns = rest.getForObject(url, JsonNode.class);

        // 3. Daca n-a gasit nimic, returnam null
        if (raspuns == null || raspuns.path("totalItems").asInt() == 0) {
            return null;
        }

        // 4. Extragem datele din primul rezultat
        JsonNode info = raspuns.path("items").get(0).path("volumeInfo");

        carte c = new carte();
        c.setIsbn(cleanIsbn);
        c.setTitlu(info.path("title").asText(""));
        c.setAutor(joinAutori(info.path("authors")));
        c.setEditie(info.path("publishedDate").asText("")); // ex: "2018-04-15"
        c.setStatus("disponibil");
        return c;
    }

    // Concateneaza array-ul de autori intr-un string: ["Mihai", "Ion"] -> "Mihai,
    // Ion"
    private String joinAutori(JsonNode autori) {
        if (!autori.isArray())
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < autori.size(); i++) {
            if (i > 0)
                sb.append(", ");
            sb.append(autori.get(i).asText());
        }
        return sb.toString();
    }
}
