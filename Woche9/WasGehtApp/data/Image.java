package data;

public class Image implements data.Data {

    @Override
    public String prettyPrint() {
        String holy = "nananananananananananaNAnanananananananananananaNanananananananaNANANANAnanananananananananaNAnanaNanananananaNANANANAnanananananananananananaNANANANanananaNANANANANANAnanananananananananananaNANANANananaNANANANANANANANANAnananananananananaNANANANANanaNANANANANANANANANANANANANANANANANANANANANANANANaNANANANANANANANANANANANANANANANANANANANANANANANANaNANANANANANANANANANANANANANANANANANANANANANANANANaNANANANANANANANANANANANANANANANANANANANANANANANANanaNANANANANANANANANANANANANANANANANANANANANANANANananaNANANANANAnananananananaNANANANANANANANANANANananananaNANANANAnananananananaNANANAnanananaNANANanananananananaNANAnananananananaNAnanananananaNANa";
        String result = "";
        int n = 0;

        for(int i = 0; i < holy.length(); i +=2) {
            String boyWonder = holy.substring(i, i+2);

            if (boyWonder.equals("na")) {
                result += " ";
            } else if (boyWonder.equals("NA")) {
                result += "*";
            } else if (boyWonder.equals("Na")) {
                result += new StringBuilder(result.substring(n)).reverse().toString() + "\n";
                n = result.length();
            }
        }
        return result;
    }
}
