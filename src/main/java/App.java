import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    Dictionary newDictionary = new Dictionary();

    get("/", (request,response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("Dictionary",newDictionary);
      model.put("template","templates/index.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    // get("/success", (request,response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template","templates/success.vtl");
    //   return new ModelAndView(model,layout);
    // }, new VelocityTemplateEngine());

    get("/add-word", (request,response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template","templates/add-word.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    post("/add-word", (request,response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String userWord = request.queryParams("word");
      String userDefinition = request.queryParams("definition");
      Word newWord = new Word(userWord, userDefinition);
      newDictionary.addWord(newWord);
      model.put("template","templates/success.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    get("/word/:id", (request,response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word",word);
      model.put("template","templates/word.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());


    get("/word/:id/add-def", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word",word);
      model.put("template","templates/add-def.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    post("/add-def", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Definition newDef = new Definition("definition");
      newDictionary.find(Integer.parseInt(request.queryParams("wordID")));
      Word word = Word.find(Integer.parseInt(request.params(request.queryParams("wordID"))));
      model.put("word", word);
      model.put("template","templates/word.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());



  }
}
