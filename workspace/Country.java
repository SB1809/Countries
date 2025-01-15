//Sophia Babayev
//1/14/2025
//Creates all the information about the countrys that is then used in the Main class.
public class Country
{
  // add private instance variables for the name, capital, language, and image file.
    private String name;
    private String capital;
    private String language;
    private String imageFile;

  // add constructors
    public Country(String name, String capital, String language, String imageFile){
      this.name = name;
      this.capital = capital;
      this.language = language;
      this.imageFile = imageFile;
    }
    public Country(String name, String capital, String language){
      this.name = name;
      this.capital = capital;
      this.language = language;
    }

  // Write accessor/get methods for each instance variable that returns it.
    public String getName(){
      return name;
    }

    public String getCapital(){
      return capital;
    }

    public String getlanguage(){
      return language;
    }

    public String getImagefile(){
      return imageFile;
    }
  // Write a toString() method that returns a concatenated String of 3 of the instance variables in a sentence like "..'s capital is .. and its primary language is ..."
    public String toString(){
      return name + "'s capital is " + capital + " and its primary language is " + language;
    }

  
}