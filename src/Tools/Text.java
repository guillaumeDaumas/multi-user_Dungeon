package Tools;

import static Tools.Colors.*;

public class Text {
    public static void welcome(){
        System.out.println("\t\t████████▄  ███    █▄  ███▄▄▄▄      ▄██████▄     ▄████████  ▄██████▄  ███▄▄▄▄");
        System.out.println("\t\t███   ▀███ ███    ███ ███▀▀▀██▄   ███    ███   ███    ███ ███    ███ ███▀▀▀██▄ ");
        System.out.println("\t\t███    ███ ███    ███ ███   ███   ███    █▀    ███    █▀  ███    ███ ███   ███");
        System.out.println("\t\t███    ███ ███    ███ ███   ███  ▄███         ▄███▄▄▄     ███    ███ ███   ███");
        System.out.println("\t\t███    ███ ███    ███ ███   ███ ▀▀███ ████▄  ▀▀███▀▀▀     ███    ███ ███   ███");
        System.out.println("\t\t███    ███ ███    ███ ███   ███   ███    ███   ███    █▄  ███    ███ ███   ███");
        System.out.println("\t\t███   ▄███ ███    ███ ███   ███   ███    ███   ███    ███ ███    ███ ███   ███");
        System.out.println("\t\t████████▀  ████████▀   ▀█   █▀    ████████▀    ██████████  ▀██████▀   ▀█   █▀\n");
    }


    public static void bye(){
        System.out.println("\t\t   ▄██████▄   ▄██████▄   ▄██████▄  ████████▄       ▀█████████▄  ▄██   ▄      ▄████████      ");
        System.out.println("\t\t  ███    ███ ███    ███ ███    ███ ███   ▀███        ███    ███ ███   ██▄   ███    ███      ");
        System.out.println("\t\t  ███    █▀  ███    ███ ███    ███ ███    ███        ███    ███ ███▄▄▄███   ███    █▀       ");
        System.out.println("\t\t ▄███        ███    ███ ███    ███ ███    ███       ▄███▄▄▄██▀  ▀▀▀▀▀▀███  ▄███▄▄▄          ");
        System.out.println("\t\t▀▀███ ████▄  ███    ███ ███    ███ ███    ███      ▀▀███▀▀▀██▄  ▄██   ███ ▀▀███▀▀▀          ");
        System.out.println("\t\t  ███    ███ ███    ███ ███    ███ ███    ███        ███    ██▄ ███   ███   ███    █▄       ");
        System.out.println("\t\t  ███    ███ ███    ███ ███    ███ ███   ▄███        ███    ███ ███   ███   ███    ███      ");
        System.out.println("\t\t  ████████▀   ▀██████▀   ▀██████▀  ████████▀       ▄█████████▀   ▀█████▀    ██████████");
    }
    /**
     * renvoi le texte sous le format graphique choisi pour les instructions
     * @param text
     * @return
     */
    public static String instruction(String text){
        return Colors.bold.getValue()+Colors.blue.getValue()+text+Colors.reset.getValue();
    }

    /**
     * mets en forme un texte d'erreur
     * @param text
     * @return
     */
    public static String error(String text){
        return red(text);
    }

    /**
     * mets en forme un texte de succès
     * @param text
     * @return
     */
    public static String success(String text){
        return green(text);
    }


    /**
     * mets en forme un texte de type basique
     * @param text
     * @return
     */
    public static String basic(String text){
        return cyan(text);
    }

    /**
     * permet d'afficher un texte au format instruction
     * @param text
     */
    public static void printI(String text){
        System.out.println(instruction(text));
    }

    /**
     * Affiche un texte d'erreur au format d'erreur
     * @param text
     */
    public static void printE(String text){
        System.out.println(error(text));
    }

    /**
     * Affiche un texte au format "succès"
     * @param text
     */
    public static void printS(String text){
        System.out.println(success(text));
    }

    /**
     * Affiche un texte au format basique
     * @param text
     */
    public static void prinB(String text){
        System.out.println(basic(text));
    }
}
