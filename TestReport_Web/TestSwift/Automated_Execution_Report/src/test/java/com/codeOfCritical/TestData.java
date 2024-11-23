/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 *   TestData.java belongs to codeOfCritical
 *   Do not COPY or PASTE code to WEB from demoBDDFramework
 *   Creation date-time : 03/07/20, 7:03 PM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCritical;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestData
{

//    public static String pathOfReportGeneration = System.getProperty("user.dir")+ File.separator+"Automated_Execution_Report/src/main/java/com/codeOfCritical/html/";
public static String pathOfReportGeneration  ="../TestReport_Web/TestSwift/Automated_Execution_Report/src/main/java/com/codeOfCritical/html/";
    public static List<String> screens = List.of("E:\\gitClone\\demoBDDFramework\\screenShots\\07-Aug-2019__02_39_46PM\\2019_08_07T14_39_58_004443700.png",
            "E:\\gitClone\\demoBDDFramework\\screenShots\\07-Aug-2019__02_39_46PM\\2019_08_07T14_43_28_970857100.png",
            "E:\\gitClone\\demoBDDFramework\\screenShots\\07-Aug-2019__02_39_46PM\\2019_08_07T14_50_50_689343400.png");

    public static Map<String, Map<String, Double>> exp = null;
    public static Map<String, Map<String, Double>> act = null;
    public static Map<String, Map<String, Double>> act1 = null;
    public static Map<String, Map<String, Double>> act2 = null;

    static
    {
        exp = new HashMap<String, Map<String, Double>>();
        act = new HashMap<String, Map<String, Double>>();
        act1 = new HashMap<String, Map<String, Double>>();
        act2 = new HashMap<String, Map<String, Double>>();

        exp.put("abc", Map.of("sav", 10120.00, "fd", 1130.30, "rd", 35540.55));
        exp.put("ice", Map.of("sav", 2213.20, "fd", 9805.00, "rd", 6340.65));
        exp.put("fire", Map.of("sav", 5127.00, "fd", 1130.00, "rd", 3450.58));
        exp.put("water", Map.of("sav", 6780.00, "fd", 22510.00, "rd", 3341.55));
        exp.put("spirit", Map.of("sav", 9770.00, "fd", 14710.00, "rd", 4334.55));
        exp.put("ether", Map.of("sav", 1780.00, "fd", 14540.00, "rd", 5541.55));


        act.put("abc", Map.of("sav", 10000.00, "fd", 1130.30, "rd", 34440.44));
        act.put("ice", Map.of("sav", 2883.20, "fd", 9804.00, "rd", 6340.64));
        act.put("fire", Map.of("sav", 4129.00, "fd", 1130.00, "rd", 3440.48));
        act.put("water", Map.of("sav", 9980.00, "fd", 14410.00, "rd", 9341.44));


        act1.put("abc", Map.of("sav", 10000.00, "fd", 1130.30, "rd", 34440.44));
        act1.put("ice", Map.of("sav", 2883.20, "fd", 9804.00, "rd", 6340.64));
        act1.put("fire", Map.of("sav", 4129.00, "fd", 1130.00, "rd", 3440.48));
        act1.put("water", Map.of("sav", 9980.00, "fd", 14410.00, "rd", 9341.44));
        act1.put("soda", Map.of("sav", 6780.00, "fd", 22510.00, "rd", 3341.55));
        act1.put("spirit", Map.of("sav", 9770.00, "fd", 14710.00, "rd", 4334.55));
        act1.put("ether", Map.of("sav", 1780.00, "fd", 14540.00, "rd", 5541.55));
        act1.put("wine", Map.of("sav", 6780.00, "fd", 92510.10, "rd", 3311.55));
        act1.put("Molt", Map.of("sav", 9770.00, "fd", 64710.00, "rd", 4134.55));
        act1.put("Coke", Map.of("sav", 1990.00, "fd", 94540.00, "rd", 5111.15));


        act1.put("LQVG", Map.of("QNOD", 8959.42016809734, "KWIN", 900380.893410570612864, "VXGU", 5777380.766809730005154));
        act1.put("PHKB", Map.of("YKOG", 26930.7918014101, "RYVQ", 7168840.201901151512427, "ZFGV", 2214100.915546294636615));
        act1.put("WQDZ", Map.of("SUGF", 808857.64028977, "IUMY", 2025110.31469606466605, "APHX", 6708980.929879361319074));
        act1.put("BDXR", Map.of("GHZS", 87472.6608265641, "TAWP", 6892590.932832194798575, "AADC", 2202940.363961331017195));
        act1.put("CVZI", Map.of("GQFY", 826177.542867485, "ETSH", 6670110.725136024637097, "ZAGA", 3787750.257297183067615));
        act1.put("YQQB", Map.of("GJYJ", 417053.804090585, "DXEX", 2935880.0941003006582297, "PWKZ", 797290.713533827302102));
        act1.put("KNPL", Map.of("MHEH", 609293.816693976, "XLHL", 5051710.828613661664668, "TBWC", 4264160.717304352880246));
        act1.put("ZDJK", Map.of("VCGS", 179628.562313453, "OQJL", 6339960.481412668592919, "VVCI", 4241580.658610815548665));
        act1.put("QRYU", Map.of("PJDR", 724146.552881258, "QVWQ", 4056610.850251100525552, "HFHQ", 6185340.707674930865162));
        act1.put("SLUR", Map.of("NFTD", 94267.6009294721, "MGIX", 659930.569809560572893, "FVXA", 6672150.659903400118507));
        act1.put("LOXL", Map.of("XCUL", 217881.264470789, "JRSU", 2514000.570945978951127, "PJUV", 5807280.319613730473868));
        act1.put("LEAY", Map.of("TLQG", 69851.0520998725, "HQMF", 2662830.987311235167909, "VGRD", 4809160.378142119120902));
        act1.put("KGSY", Map.of("QJRQ", 910818.660700954, "FIST", 2996590.630430794316562, "DGQV", 6661140.576828919029296));
        act1.put("KSRJ", Map.of("WVPU", 110172.803428757, "SJEQ", 3355920.919510061678659, "CVWK", 5214480.974433904931429));
        act1.put("RQBI", Map.of("QXOZ", 685818.782346194, "QYAC", 3111410.329434930714925, "OSSE", 2656200.254477476235512));
        act1.put("SOTO", Map.of("CUXC", 477373.730871379, "YQOK", 5342310.790367115795286, "AQMM", 1019950.689364008310629));
        act1.put("YAXJ", Map.of("JPNA", 119031.704249326, "FVID", 5905210.566884066155165, "AWSG", 6519680.804242034277834));
        act1.put("FSVV", Map.of("XEPP", 798124.132714303, "SNZF", 3405350.658423519013336, "YXAW", 994580.664686751458917));
        act1.put("FBXL", Map.of("JXAO", 842349.226906946, "ZCFG", 3367720.18135695588758, "OOXU", 1976550.396317190557198));
        act1.put("CFFJ", Map.of("QATC", 508372.796026198, "EXZZ", 1031180.396436844342547, "MCJX", 882620.215039960613463));
        act1.put("XGCR", Map.of("JLRT", 223879.492065136, "NTRL", 7162020.302288944008763, "DQGF", 4491630.635951548915065));
        act1.put("OSOB", Map.of("SLMR", 26698.1462136453, "EQFM", 1814250.687475458089011, "IITR", 4153390.0688055716703465));
        act1.put("KWXE", Map.of("JCKA", 375980.090942654, "ENLQ", 2276220.722089838850788, "PWBH", 844700.218775227513852));
        act1.put("SHGQ", Map.of("AGJC", 17231.094229814, "PIOP", 2523670.305226921941748, "DSFN", 1235430.202144244592926));
        act1.put("RUAR", Map.of("XRUQ", 181988.20731831, "CIJZ", 853080.744047792571317, "GUWY", 5213990.516868215081957));
        act1.put("JPNF", Map.of("YJLT", 498768.119142737, "DQSK", 4666490.561280694053186, "LFPG", 3824370.982726982966761));
        act1.put("VIDQ", Map.of("KPLN", 325502.06469849, "EFXX", 642980.448291290843402, "GZWC", 4103270.374926019736799));
        act1.put("TDZG", Map.of("BMUI", 989580.569345907, "WXQH", 7412750.730011349405724, "YSEX", 5305370.212475246394145));
        act1.put("GDZC", Map.of("VSNY", 509580.262828309, "JPGK", 2667070.0341214549076226, "ODII", 5062970.64007471567235));
        act1.put("SLMM", Map.of("QDEB", 151943.452496449, "IQQF", 3677420.644914808232795, "IWGI", 5322650.928610843672359));
        act1.put("KAAP", Map.of("ZAQX", 69437.5115781992, "RQIO", 696780.433436835085528, "XBBW", 3199440.406084624208735));
        act1.put("CEHW", Map.of("JQLS", 837117.361945886, "OOSC", 6492820.868939109292556, "FVWO", 3264320.780792400770175));
        act1.put("CFGZ", Map.of("LBKO", 515272.49623458, "YSQY", 5153180.698780895878585, "OVGT", 6948560.453454586995368));
        act1.put("VDMV", Map.of("WMZW", 362812.741046516, "YASJ", 7197670.883190017461488, "QARA", 5280070.431947848685768));
        act1.put("TQTQ", Map.of("TRNZ", 516435.951705185, "GDOH", 3541230.481847799888537, "WDNI", 1769530.210544546412253));


        act2.put("QVID", Map.of("NIBN", 61238.7387995372, "DGCA", 4966680.701366232631052, "ULHN", 3255830.529528247491196));
        act2.put("RPAC", Map.of("PQHQ", 28506.6175395263, "AOXJ", 6997660.567130153031227, "EUXG", 649910.644197996044253));
        act2.put("OIAC", Map.of("JTFR", 13587.5321770511, "XHFT", 877710.84743186978375, "BHSK", 891550.920326316715986));
        act2.put("SYGA", Map.of("JAFP", 56044.8198227152, "ECYS", 1841300.698312000549927, "KDVW", 1784810.163088706168875));
        act2.put("WTSW", Map.of("OAPD", 97814.8483261848, "XDJS", 828620.27023657367444, "TZKB", 7391740.928041142454017));
        act2.put("FLLZ", Map.of("RGXO", 23458.0715774686, "IUBW", 5555780.809493385672708, "OXAO", 1233220.422779730137655));
        act2.put("FSJN", Map.of("IANF", 12687.1124499085, "GITH", 2850700.247315098615115, "PJUB", 2710610.969086992826426));
        act2.put("CCLA", Map.of("SKGG", 31988.3012586965, "QWNK", 0.0, "IIOH", 4920300.428982123303601));
        act2.put("HAUA", Map.of("BXGX", 27151.5131548574, "WJDI", 4119230.155888630681976, "BORV", 6525050.344884676857279));
        act2.put("NSCB", Map.of("PFEL", 25575.6615739946, "DVIF", 2740070.888726141598934, "TSFA", 605370.478289023907372));
        act2.put("AEJG", Map.of("SFKT", 119604.109222024, "CXNT", 6450650.453388822225679, "YIBR", 5316250.126158835947786));
        act2.put("YWRF", Map.of("POIF", 24790.1705455692, "EPEV", 6304800.106310009090144, "CJOV", 548130.0143661340777966));
        act2.put("RICM", Map.of("CEMX", 42115.9328857533, "HTCH", 6422150.138711588621937, "IZCT", 1488150.279247400385911));
        act2.put("UZIK", Map.of("ASCF", 4750.51679649832, "PIYA", 7494930.0600054558506731, "FNVC", 2786650.656612889930456));
        act2.put("TCIV", Map.of("NYXM", 4811.99629070254, "CJGT", 3616540.219810026991798, "XSYP", 5993440.332347834756336));
        act2.put("SUON", Map.of("BADW", 14726.0943992491, "SYMA", 5323200.167012569528657, "LZCV", 3048230.271779898176095));
        act2.put("VBUG", Map.of("NBTX", 38478.7847643537, "CMYK", 5951250.433896840942372, "OIYX", 6949720.274958199633798));
        act2.put("JEGG", Map.of("VEMC", 2729.1060926658, "WIOF", 5947570.490120978543847, "YKOR", 2551760.629536104848611));
        act2.put("WRAW", Map.of("HEKM", 14317.224679465, "VNOP", 1267070.691834724071679, "GLPX", 0.0));
        act2.put("BXUH", Map.of("UDCF", 8501.77063527226, "EYLN", 1539160.529689391675598, "PLLB", 4609350.875150365062747));
        act2.put("YIBK", Map.of("FWAS", 67506.0381785347, "HVEG", 1328040.794987512215838, "WFZZ", 6898410.203150997047097));
        act2.put("NYDY", Map.of("CMAF", 4178.62099923205, "ZGNV", 6541580.996183639603604, "AKOI", 2275140.538888876599844));
        act2.put("ZIKP", Map.of("GLYK", 45474.6104294274, "NGJW", 7408900.976388144474642, "ZYTJ", 4821570.182089834882367));
        act2.put("RWAI", Map.of("IQJN", 17079.7103684676, "BUKI", 4805690.676157721155517, "JLPF", 6295380.0834543418403));
        act2.put("BGCZ", Map.of("ZDTU", 15064.0128748064, "OQOT", 5693730.375691240775394, "LYEB", 735200.383597135232407));
        act2.put("BDDL", Map.of("XLPH", 57646.2391029465, "KKBA", 649120.104028052344627, "HHEI", 4001280.451114688764215));
        act2.put("THJX", Map.of("SQEX", 34231.7094465851, "WFHA", 3151990.139203222451965, "GJCB", 5703910.0589733483909389));
        act2.put("SXWR", Map.of("EMGT", 47835.8673858279, "USZC", 707750.966939468980208, "FFTJ", 6991010.416796622549231));
        act2.put("GHTV", Map.of("GHYI", 52324.369944577, "LXWC", 2220790.882438312006444, "EUZB", 5841620.710396211602105));
        act2.put("WEMM", Map.of("QPKG", 73031.8769694793, "UFWA", 4942590.668791636141762, "RWUK", 7576420.727775965266773));
        act2.put("JIUZ", Map.of("QULW", 77042.1079699896, "FIMS", 3720910.122254276800528, "KVAM", 6559350.390276868279113));
        act2.put("FGVA", Map.of("LZGU", 52297.9637070018, "EVMC", 5420800.513961192348341, "VXDS", 3574990.859888085398597));
        act2.put("PUNS", Map.of("BVFC", 33122.5788633009, "GMYW", 2595450.272455841671705, "XADX", 6847180.906439846716492));
        act2.put("IQJH", Map.of("BOBL", 34494.4598934261, "FDSO", 2280290.935909313213302, "KQMI", 7395110.260339394637055));
        act2.put("JLMS", Map.of("DWVN", 48597.5357763922, "JIAU", 5260820.554924387756961, "RDWZ", 4516750.138940084015332));


    }
}
