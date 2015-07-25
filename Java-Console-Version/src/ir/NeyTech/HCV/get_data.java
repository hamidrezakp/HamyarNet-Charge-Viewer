package ir.NeyTech.HCV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class get_data {
    public static String[] main(String username, String password) {
        String gig = null, charge = null, createdIn = null, expireIn = null, savedGig = null, savedCharge = null, freeNight = null, uname = null;

        URL url;
        try {
            url = new URL("http://accounting.hamyar.net/IBSng/user/index.php?normal_username=" + username + "&normal_password=" + password);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Cookie", "IBS_SESSID=hlpjpnm8hdrf84n7igk0m5n9v6; session_id=f49f028f0c3b87719638136ce5cd5f23090eca5e");
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;
            List<String> lines = new ArrayList<String>();
            while ((inputLine = br.readLine()) != null) {
                lines.add(inputLine);
            }
            for (int n = 0; n < lines.size(); n++) {
                String line = lines.get(n);
                if (line.contains("            <td class=\"List_Col\" valign=\"Middle\" >                           ") && line.contains("</sub>")) {
                    gig = getBetween(line, "            <td class=\"List_Col\" valign=\"Middle\" >                           ", "<sub>") + getBetween(line, "<sub>", "</sub>");

                }
                if (line.contains("                    <td class=\"Form_Content_Row_Right_2Col_light\">") && line.contains("RIALS</td>")) {
                    charge = getBetween(line, "                    <td class=\"Form_Content_Row_Right_2Col_light\">", "</td>");
                }
                if (line.contains("                    <td class=\"Form_Content_Row_Right_2Col_light\">") && line.contains("</td>")) {
                    createdIn = getBetween(line, "                    <td class=\"Form_Content_Row_Right_2Col_light\">", "</td>");
                }
                if (line.contains("</td>                    <td class=\"Form_Content_Row_Right_2Col_light\">") && lines.get(n - 1).contains("                <td class=\"Form_Content_Row_Begin\"><img border=\"0\" src=\"/IBSng/images/row/begin_of_row_light.gif\"></td>")) {
                    expireIn = getBetween(line, "</td>                    <td class=\"Form_Content_Row_Right_2Col_light\">", "</td>");
                }
                if (line.contains("Renew :</td>                    <td class=\"Form_Content_Row_Right_2Col_dark\">")) {
                    savedCharge = getBetween(line, "Renew :</td>                    <td class=\"Form_Content_Row_Right_2Col_dark\">", "</td>");
                }
                if (line.contains("                    <td class=\"Form_Content_Row_Right_2Col_dark\">") && line.contains("<span>GB</span></td>")) {
                    savedGig = getBetween(line, "                    <td class=\"Form_Content_Row_Right_2Col_dark\">", " &nbsp;<span>GB</span></td>") + " GIG";
                }
                if (line.contains("            <td class=\"List_Col\" valign=\"Middle\" >                           ") && lines.get(n - 1).contains("                    </td>           ") && lines.get(n - 2).contains("        </td>            <td class=\"List_Col\" valign=\"Middle\" >                           -")) {
                    if (line.matches(".*\\d.*")) {
                        freeNight = "NO!";
                    } else {
                        freeNight = "YES!";
                    }
                }

                if (line.contains(":</td>                    <td class=\"Form_Content_Row_Right_2Col_light\">") && !lines.get(n + 2).contains("                    <td class=\"Form_Content_Col_Space\">&nbsp;</td>")) {
                    uname = getBetween(line, "<td class=\"Form_Content_Row_Right_2Col_light\">", "</td>");
                }
            }
            br.close();
    }

    catch(
    IOException e
    )

    {
    }

    return new String[]

    {
        gig, charge, createdIn, expireIn, savedGig, savedCharge, freeNight, uname
    }

    ;
}




    public static String getBetween(String str, String open, String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start + open.length());
            if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }

}



