import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class EvaluatePolynomialsFromString {

    public static void main(String[] args) {

    }

    public static int evalPolynomial(String poly, int num) {
        if (poly.matches(".*\\&.*|.*//.*")) {
            return -1;
        }

        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
            poly=poly
                    .replaceAll("([\\d]+)x","$1*x")
                    .replaceAll("([\\dx]+)\\(","$1*(")
                    .replaceAll("([\\dx]+)\\^(\\d+)", "Math.pow($1, $2)")
                    .replace("x", ""+num);

            return (int)Double.parseDouble(engine.eval(poly).toString());

        } catch (Exception e) {
            return -1;
        }
    }
}
