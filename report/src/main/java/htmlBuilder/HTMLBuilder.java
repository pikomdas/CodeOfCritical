package htmlBuilder;

import JSONReader.JSONReader;

public class HTMLBuilder extends JSONReader {

    StringBuilder fp = new StringBuilder();

    public String firstPartOfReport(String jsonPath) {
        try {
            fp.append("<html lang=\"en\">\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
                    + "<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"https://www.assetvantage.com/wp-content/uploads/2016/04/AVfavicon.png\" />\r\n"
                    + "<link rel=\"mask-icon\" type=\"\" href=\"https://www.assetvantage.com/wp-content/uploads/2016/04/AVfavicon.png\" color=\"#111\" />\r\n"
                    + "<title>Jenkins Email-able Report</title>\r\n");
            fp.append("<style type=\"text/css\">\r\n" + "h1{\r\n" + "  font-size: 30px;\r\n" + "  color: #333333;\r\n"
                    + "  text-transform: uppercase;\r\n" + "  font-weight: 300;\r\n" + "  text-align: center;\r\n"
                    + "  margin-bottom: 15px;\r\n" + "}"
                    + ".tftable {font-size:12px;color:#333333;width:100%;border-width: 1px;border-color: #729ea5;border-collapse: collapse;}\r\n"
                    + ".tftable th {font-size:12px;background-color:#acc8cc;border-width: 1px;padding: 8px;border-style: solid;border-color: #729ea5;text-align:left;}\r\n"
                    + ".tftable tr {background-color:#d4e3e5;}\r\n"
                    + ".tftable td {font-size:12px;border-width: 1px;padding: 8px;border-style: solid;border-color: #729ea5;}\r\n"
                    + ".tftable tr:hover {background-color:#ffffff;}\r\n" + "td.passed {\r\n"
                    + "    background-color: #25c481;\r\n" + "}" + "td.failed {\r\n"
                    + "    background-color: #9b6e6f91;\r\n" + "}" + "</style>");
            fp.append("</head><body>");
            fp.append("<h1>Execution Report</h1>");
            fp.append("<div class=\"tftable\">\r\n" + "    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
                    + "      <thead id=\"myHeader\">\r\n" + "        <tr>\r\n" + "          <th>Feature</th>\r\n"
                    + "          <th>Scenario</th>\r\n" + "          <th>Status</th>\r\n" + "  </tr></thead>");
            fp.append("<tbody>");
            fp.append(getTable(jsonPath));
            fp.append("</tbody>");
            fp.append("</table></div>");

            fp.append(
                    "<script src=\"https://static.codepen.io/assets/common/stopExecutionOnTimeout-de7e2ef6bfefd24b79a3f68b414b87b8db5b08439cac3f1012092b2290c719cd.js\"></script>\r\n"
                            + "<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\r\n"
                            + "<script id=\"rendered-js\">\r\n"
                            + "      // '.tbl-content' consumed little space for vertical scrollbar, scrollbar width depend on browser/os/platfrom. Here calculate the scollbar width .\r\n"
                            + "$(window).on(\"load resize \", function () {\r\n"
                            + "  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();\r\n"
                            + "  $('#myHeader').css({ 'padding-right': scrollWidth });\r\n" + "}).resize();\r\n"
                            + "    </script>" + "</body>" + "</html>");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fp.toString();
    }
}
