/* The following code was generated by JFlex 1.4.3 on 02/07/15 01:24 PM */

package lema;
import java_cup.runtime.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 02/07/15 01:24 PM from the specification file
 * <tt>J:/CO/Software/LeMa 1.5/LeMa/src/lema/lexico.flex</tt>
 */
class Lexico implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\2\4\2\0\1\4\22\0\1\4\1\40\1\54\2\0\1\31"+
    "\1\43\1\32\1\23\1\24\1\6\1\27\1\56\1\30\1\52\1\5"+
    "\1\51\11\3\1\46\1\55\1\41\1\37\1\42\1\45\1\0\6\2"+
    "\24\1\1\47\1\0\1\50\1\33\1\1\1\0\1\15\1\1\1\7"+
    "\1\22\1\17\1\60\1\1\1\57\1\16\2\1\1\21\1\35\1\11"+
    "\1\10\1\36\1\1\1\20\1\12\1\13\1\34\1\14\1\1\1\53"+
    "\2\1\1\25\1\44\1\26\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\10\1\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\2\1\1\17\1\20\1\21\1\22\2\0\1\23\1\24"+
    "\1\25\1\26\1\2\1\0\1\27\1\30\1\1\2\0"+
    "\1\31\1\32\3\1\1\33\10\1\1\34\1\35\1\36"+
    "\1\37\1\40\5\1\1\41\1\42\1\43\1\44\1\45"+
    "\1\46\1\47\1\0\1\50\1\1\1\51\1\0\25\1"+
    "\1\0\1\52\2\1\1\53\2\1\1\54\1\1\1\55"+
    "\6\1\1\56\1\57\3\1\1\60\2\1\1\61\1\0"+
    "\1\1\1\62\4\1\1\63\2\1\1\64\6\1\1\65"+
    "\1\66\1\67\1\70\3\1\1\71\10\1\1\72\1\1"+
    "\1\73\4\1\1\74\1\1\1\75\1\76\1\1\1\77"+
    "\3\1\1\100\1\1\1\101\1\102";

  private static int [] zzUnpackAction() {
    int [] result = new int[177];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\61\0\142\0\223\0\304\0\365\0\u0126\0\u0157"+
    "\0\u0188\0\u01b9\0\u01ea\0\u021b\0\u024c\0\u027d\0\223\0\223"+
    "\0\223\0\223\0\u02ae\0\u02df\0\u0310\0\223\0\223\0\u0341"+
    "\0\u0372\0\u03a3\0\u03d4\0\u0405\0\u0436\0\u0467\0\u0498\0\223"+
    "\0\223\0\223\0\223\0\u04c9\0\u04fa\0\223\0\223\0\u052b"+
    "\0\u055c\0\u058d\0\223\0\223\0\u05be\0\u05ef\0\u0620\0\u0651"+
    "\0\u0682\0\u06b3\0\u06e4\0\u0715\0\u0746\0\u0777\0\u07a8\0\u07d9"+
    "\0\223\0\223\0\223\0\223\0\223\0\u080a\0\u083b\0\u086c"+
    "\0\u089d\0\u08ce\0\223\0\223\0\223\0\223\0\223\0\223"+
    "\0\u08ff\0\u0930\0\223\0\u0961\0\u055c\0\u0992\0\u09c3\0\u09f4"+
    "\0\u0a25\0\u0a56\0\u0a87\0\u0ab8\0\u0ae9\0\u0b1a\0\u0b4b\0\u0b7c"+
    "\0\u0bad\0\u0bde\0\u0c0f\0\u0c40\0\u0c71\0\u0ca2\0\u0cd3\0\u0d04"+
    "\0\u0d35\0\u0d66\0\u0d97\0\u0dc8\0\u0df9\0\u0e2a\0\u0e5b\0\61"+
    "\0\u0e8c\0\u0ebd\0\61\0\u0eee\0\61\0\u0f1f\0\u0f50\0\u0f81"+
    "\0\u0fb2\0\u0fe3\0\u1014\0\61\0\61\0\u1045\0\u1076\0\u10a7"+
    "\0\61\0\u10d8\0\u1109\0\u0dc8\0\u113a\0\u116b\0\61\0\u119c"+
    "\0\u11cd\0\u11fe\0\u122f\0\61\0\u1260\0\u1291\0\61\0\u12c2"+
    "\0\u12f3\0\u1324\0\u1355\0\u1386\0\u13b7\0\u113a\0\61\0\61"+
    "\0\61\0\u13e8\0\u1419\0\u144a\0\61\0\u147b\0\u14ac\0\u14dd"+
    "\0\u150e\0\u153f\0\u1570\0\u15a1\0\u15d2\0\61\0\u1603\0\61"+
    "\0\u1634\0\u1665\0\u1696\0\u16c7\0\61\0\u16f8\0\61\0\61"+
    "\0\u1729\0\61\0\u175a\0\u178b\0\u17bc\0\61\0\u17ed\0\61"+
    "\0\61";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[177];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\0\2\2\1\3\1\4\1\5\1\6\1\7\2\2"+
    "\1\10\1\11\1\12\1\2\1\13\1\14\1\15\1\16"+
    "\1\2\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\2\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\0\1\2\1\45\1\46\1\47\1\50\1\2\1\0"+
    "\3\2\3\0\14\2\11\0\3\2\12\0\1\2\1\0"+
    "\1\2\3\0\2\2\3\0\1\3\45\0\1\3\1\51"+
    "\75\0\1\52\30\0\1\53\60\0\1\54\22\0\3\2"+
    "\3\0\1\2\1\55\4\2\1\56\5\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\6\2\1\57\1\60\1\61\3\2\11\0\1\62"+
    "\2\2\12\0\1\2\1\0\1\2\3\0\2\2\1\0"+
    "\3\2\3\0\11\2\1\63\2\2\11\0\3\2\12\0"+
    "\1\2\1\0\1\2\3\0\2\2\1\0\3\2\3\0"+
    "\6\2\1\64\5\2\11\0\3\2\12\0\1\2\1\0"+
    "\1\2\3\0\2\2\1\0\3\2\3\0\2\2\1\65"+
    "\11\2\11\0\3\2\12\0\1\2\1\0\1\2\3\0"+
    "\2\2\1\0\3\2\3\0\2\2\1\66\11\2\11\0"+
    "\3\2\12\0\1\2\1\0\1\2\3\0\2\2\1\0"+
    "\3\2\3\0\10\2\1\67\3\2\11\0\3\2\12\0"+
    "\1\2\1\0\1\2\3\0\2\2\1\0\3\2\3\0"+
    "\10\2\1\70\3\2\11\0\3\2\12\0\1\2\1\0"+
    "\1\2\3\0\2\2\27\0\1\71\7\0\1\72\51\0"+
    "\1\73\6\0\1\74\60\0\1\75\22\0\3\2\3\0"+
    "\1\2\1\76\5\2\1\77\4\2\11\0\3\2\12\0"+
    "\1\2\1\0\1\2\3\0\2\2\1\0\3\2\3\0"+
    "\1\2\1\100\4\2\1\101\2\2\1\102\2\2\11\0"+
    "\3\2\12\0\1\2\1\0\1\2\3\0\2\2\37\0"+
    "\1\103\60\0\1\104\60\0\1\105\60\0\1\106\64\0"+
    "\1\107\61\0\1\110\17\0\1\111\45\0\1\111\1\51"+
    "\1\112\5\0\54\45\1\113\4\45\1\0\3\2\3\0"+
    "\6\2\1\114\5\2\11\0\3\2\12\0\1\2\1\0"+
    "\1\2\3\0\2\2\3\0\1\115\45\0\1\115\7\0"+
    "\6\52\1\116\52\52\1\0\3\2\3\0\2\2\1\117"+
    "\11\2\11\0\3\2\12\0\1\2\1\0\1\2\3\0"+
    "\2\2\1\0\3\2\3\0\3\2\1\120\7\2\1\121"+
    "\11\0\3\2\12\0\1\2\1\0\1\2\3\0\2\2"+
    "\1\0\3\2\3\0\12\2\1\122\1\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\2\2\1\123\11\2\11\0\3\2\12\0\1\2"+
    "\1\0\1\2\3\0\2\2\1\0\3\2\3\0\12\2"+
    "\1\124\1\2\11\0\3\2\12\0\1\2\1\0\1\2"+
    "\3\0\2\2\1\0\3\2\3\0\14\2\11\0\1\2"+
    "\1\125\1\2\12\0\1\2\1\0\1\2\3\0\2\2"+
    "\1\0\3\2\3\0\6\2\1\126\5\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\1\127\13\2\11\0\3\2\12\0\1\2\1\0"+
    "\1\2\3\0\2\2\1\0\3\2\3\0\5\2\1\130"+
    "\6\2\11\0\3\2\12\0\1\2\1\0\1\2\3\0"+
    "\2\2\1\0\3\2\3\0\4\2\1\131\7\2\11\0"+
    "\3\2\12\0\1\2\1\0\1\2\3\0\2\2\1\0"+
    "\3\2\3\0\3\2\1\132\1\133\1\2\1\134\5\2"+
    "\11\0\3\2\12\0\1\2\1\0\1\2\3\0\2\2"+
    "\1\0\3\2\3\0\10\2\1\135\3\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\3\2\1\136\10\2\11\0\3\2\12\0\1\2"+
    "\1\0\1\2\3\0\2\2\1\0\3\2\3\0\10\2"+
    "\1\137\3\2\11\0\3\2\12\0\1\2\1\0\1\2"+
    "\3\0\2\2\1\0\3\2\3\0\11\2\1\140\2\2"+
    "\11\0\3\2\12\0\1\2\1\0\1\2\3\0\2\2"+
    "\1\0\3\2\3\0\11\2\1\141\2\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\1\2\1\142\5\2\1\143\4\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\3\0\1\111"+
    "\45\0\1\111\1\144\10\0\2\145\45\0\1\145\10\0"+
    "\3\2\3\0\1\146\13\2\11\0\3\2\12\0\1\2"+
    "\1\0\1\2\3\0\2\2\5\52\1\4\1\116\52\52"+
    "\1\0\3\2\3\0\3\2\1\147\10\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\1\2\1\150\12\2\11\0\3\2\12\0\1\2"+
    "\1\0\1\2\3\0\2\2\1\0\3\2\3\0\10\2"+
    "\1\151\3\2\11\0\3\2\12\0\1\2\1\0\1\2"+
    "\3\0\2\2\1\0\3\2\3\0\4\2\1\152\7\2"+
    "\11\0\3\2\12\0\1\2\1\0\1\2\3\0\2\2"+
    "\1\0\3\2\3\0\1\2\1\153\12\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\10\2\1\154\3\2\11\0\3\2\12\0\1\2"+
    "\1\0\1\2\3\0\2\2\1\0\3\2\3\0\6\2"+
    "\1\155\5\2\11\0\3\2\12\0\1\2\1\0\1\2"+
    "\3\0\2\2\1\0\3\2\3\0\2\2\1\156\11\2"+
    "\11\0\3\2\12\0\1\2\1\0\1\2\3\0\2\2"+
    "\1\0\3\2\3\0\7\2\1\157\4\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\10\2\1\160\3\2\11\0\3\2\12\0\1\2"+
    "\1\0\1\2\3\0\2\2\1\0\3\2\3\0\10\2"+
    "\1\161\3\2\11\0\3\2\12\0\1\2\1\0\1\2"+
    "\3\0\2\2\1\0\3\2\3\0\4\2\1\162\7\2"+
    "\11\0\3\2\12\0\1\2\1\0\1\2\3\0\2\2"+
    "\1\0\3\2\3\0\1\2\1\163\12\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\12\2\1\164\1\2\11\0\3\2\12\0\1\2"+
    "\1\0\1\2\3\0\2\2\1\0\3\2\3\0\11\2"+
    "\1\165\2\2\11\0\3\2\12\0\1\2\1\0\1\2"+
    "\3\0\2\2\1\0\3\2\3\0\4\2\1\166\7\2"+
    "\11\0\3\2\12\0\1\2\1\0\1\2\3\0\2\2"+
    "\1\0\3\2\3\0\2\2\1\167\11\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\13\2\1\170\11\0\3\2\12\0\1\2\1\0"+
    "\1\2\3\0\2\2\1\0\3\2\3\0\6\2\1\171"+
    "\5\2\11\0\3\2\12\0\1\2\1\0\1\2\3\0"+
    "\2\2\1\0\3\2\3\0\13\2\1\172\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\2\2\1\173\11\2\11\0\3\2\12\0\1\2"+
    "\1\0\1\2\3\0\2\2\3\0\1\174\45\0\1\174"+
    "\11\0\2\145\45\0\1\145\1\175\7\0\3\2\3\0"+
    "\10\2\1\176\3\2\11\0\3\2\12\0\1\2\1\0"+
    "\1\2\3\0\2\2\1\0\3\2\3\0\4\2\1\177"+
    "\7\2\11\0\3\2\12\0\1\2\1\0\1\2\3\0"+
    "\2\2\1\0\3\2\3\0\2\2\1\200\11\2\11\0"+
    "\3\2\12\0\1\2\1\0\1\2\3\0\2\2\1\0"+
    "\3\2\3\0\6\2\1\201\5\2\11\0\3\2\12\0"+
    "\1\2\1\0\1\2\3\0\2\2\1\0\3\2\3\0"+
    "\1\202\13\2\11\0\3\2\12\0\1\2\1\0\1\2"+
    "\3\0\2\2\1\0\3\2\3\0\3\2\1\203\10\2"+
    "\11\0\3\2\12\0\1\2\1\0\1\2\3\0\2\2"+
    "\1\0\3\2\3\0\1\2\1\204\12\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\11\2\1\205\2\2\11\0\3\2\12\0\1\2"+
    "\1\0\1\2\3\0\2\2\1\0\3\2\3\0\11\2"+
    "\1\206\2\2\11\0\3\2\12\0\1\2\1\0\1\2"+
    "\3\0\2\2\1\0\3\2\3\0\6\2\1\207\5\2"+
    "\11\0\3\2\12\0\1\2\1\0\1\2\3\0\2\2"+
    "\1\0\3\2\3\0\11\2\1\210\2\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\11\2\1\211\2\2\11\0\3\2\12\0\1\2"+
    "\1\0\1\2\3\0\2\2\1\0\3\2\3\0\4\2"+
    "\1\212\7\2\11\0\3\2\12\0\1\2\1\0\1\2"+
    "\3\0\2\2\1\0\3\2\3\0\10\2\1\213\3\2"+
    "\11\0\3\2\12\0\1\2\1\0\1\2\3\0\2\2"+
    "\1\0\3\2\3\0\14\2\11\0\1\214\2\2\12\0"+
    "\1\2\1\0\1\2\3\0\2\2\1\0\3\2\3\0"+
    "\1\215\13\2\11\0\3\2\12\0\1\2\1\0\1\2"+
    "\3\0\2\2\2\0\2\216\45\0\1\216\10\0\3\2"+
    "\3\0\11\2\1\217\2\2\11\0\3\2\12\0\1\2"+
    "\1\0\1\2\3\0\2\2\1\0\3\2\3\0\6\2"+
    "\1\220\5\2\11\0\3\2\12\0\1\2\1\0\1\2"+
    "\3\0\2\2\1\0\3\2\3\0\11\2\1\221\2\2"+
    "\11\0\3\2\12\0\1\2\1\0\1\2\3\0\2\2"+
    "\1\0\3\2\3\0\4\2\1\222\7\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\14\2\11\0\2\2\1\223\12\0\1\2\1\0"+
    "\1\2\3\0\2\2\1\0\3\2\3\0\3\2\1\224"+
    "\10\2\11\0\3\2\12\0\1\2\1\0\1\2\3\0"+
    "\2\2\1\0\3\2\3\0\1\2\1\225\12\2\11\0"+
    "\3\2\12\0\1\2\1\0\1\2\3\0\2\2\1\0"+
    "\3\2\3\0\2\2\1\226\11\2\11\0\3\2\12\0"+
    "\1\2\1\0\1\2\3\0\2\2\1\0\3\2\3\0"+
    "\6\2\1\227\5\2\11\0\3\2\12\0\1\2\1\0"+
    "\1\2\3\0\2\2\1\0\3\2\3\0\11\2\1\230"+
    "\2\2\11\0\3\2\12\0\1\2\1\0\1\2\3\0"+
    "\2\2\1\0\3\2\3\0\14\2\11\0\3\2\12\0"+
    "\1\2\1\0\1\2\3\0\1\2\1\231\1\0\3\2"+
    "\3\0\1\232\13\2\11\0\3\2\12\0\1\2\1\0"+
    "\1\2\3\0\2\2\1\0\3\2\3\0\7\2\1\233"+
    "\4\2\11\0\3\2\12\0\1\2\1\0\1\2\3\0"+
    "\2\2\1\0\3\2\3\0\1\2\1\234\12\2\11\0"+
    "\3\2\12\0\1\2\1\0\1\2\3\0\2\2\1\0"+
    "\3\2\3\0\14\2\11\0\1\235\2\2\12\0\1\2"+
    "\1\0\1\2\3\0\2\2\1\0\3\2\3\0\6\2"+
    "\1\236\5\2\11\0\3\2\12\0\1\2\1\0\1\2"+
    "\3\0\2\2\1\0\3\2\3\0\6\2\1\237\5\2"+
    "\11\0\3\2\12\0\1\2\1\0\1\2\3\0\2\2"+
    "\1\0\3\2\3\0\11\2\1\240\2\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\6\2\1\241\5\2\11\0\3\2\12\0\1\2"+
    "\1\0\1\2\3\0\2\2\1\0\3\2\3\0\10\2"+
    "\1\242\3\2\11\0\3\2\12\0\1\2\1\0\1\2"+
    "\3\0\2\2\1\0\3\2\3\0\4\2\1\243\7\2"+
    "\11\0\3\2\12\0\1\2\1\0\1\2\3\0\2\2"+
    "\1\0\3\2\3\0\14\2\11\0\2\2\1\244\12\0"+
    "\1\2\1\0\1\2\3\0\2\2\1\0\3\2\3\0"+
    "\11\2\1\245\2\2\11\0\3\2\12\0\1\2\1\0"+
    "\1\2\3\0\2\2\1\0\3\2\3\0\10\2\1\246"+
    "\3\2\11\0\3\2\12\0\1\2\1\0\1\2\3\0"+
    "\2\2\1\0\3\2\3\0\11\2\1\247\2\2\11\0"+
    "\3\2\12\0\1\2\1\0\1\2\3\0\2\2\1\0"+
    "\3\2\3\0\3\2\1\250\10\2\11\0\3\2\12\0"+
    "\1\2\1\0\1\2\3\0\2\2\1\0\3\2\3\0"+
    "\1\251\13\2\11\0\3\2\12\0\1\2\1\0\1\2"+
    "\3\0\2\2\1\0\3\2\3\0\1\2\1\252\12\2"+
    "\11\0\3\2\12\0\1\2\1\0\1\2\3\0\2\2"+
    "\1\0\3\2\3\0\6\2\1\253\5\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\3\2\1\254\10\2\11\0\3\2\12\0\1\2"+
    "\1\0\1\2\3\0\2\2\1\0\3\2\3\0\4\2"+
    "\1\255\7\2\11\0\3\2\12\0\1\2\1\0\1\2"+
    "\3\0\2\2\1\0\3\2\3\0\12\2\1\256\1\2"+
    "\11\0\3\2\12\0\1\2\1\0\1\2\3\0\2\2"+
    "\1\0\3\2\3\0\4\2\1\257\7\2\11\0\3\2"+
    "\12\0\1\2\1\0\1\2\3\0\2\2\1\0\3\2"+
    "\3\0\1\2\1\260\12\2\11\0\3\2\12\0\1\2"+
    "\1\0\1\2\3\0\2\2\1\0\3\2\3\0\6\2"+
    "\1\261\5\2\11\0\3\2\12\0\1\2\1\0\1\2"+
    "\3\0\2\2";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6174];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\1\1\11\12\1\4\11\3\1\2\11\6\1"+
    "\2\0\4\11\1\1\1\0\2\11\1\1\2\0\2\11"+
    "\14\1\5\11\5\1\6\11\1\1\1\0\1\11\2\1"+
    "\1\0\25\1\1\0\30\1\1\0\64\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[177];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    private Symbol symbol(int type)
    {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value)
    {
        return new Symbol(type, yyline, yycolumn, value);
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexico(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexico(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 130) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 42: 
          { return symbol(sym.hexa_e, (new Nodo(sym.hexa_e, yytext(), yyline, yycolumn, null, true)));
          }
        case 67: break;
        case 37: 
          { return symbol(sym.y);
          }
        case 68: break;
        case 48: 
          { return symbol(sym.pr_para);
          }
        case 69: break;
        case 30: 
          { return symbol(sym.decr);
          }
        case 70: break;
        case 45: 
          { return symbol(sym.pr_suma);
          }
        case 71: break;
        case 12: 
          { return symbol(sym.mod);
          }
        case 72: break;
        case 23: 
          { return symbol(sym.punto_coma);
          }
        case 73: break;
        case 43: 
          { return symbol(sym.pr_caso);
          }
        case 74: break;
        case 44: 
          { return symbol(sym.pr_sino);
          }
        case 75: break;
        case 39: 
          { return symbol(sym.octa_e,  (new Nodo(sym.octa_e, yytext(), yyline, yycolumn, null, true)));
          }
        case 76: break;
        case 27: 
          { return symbol(sym.pr_si);
          }
        case 77: break;
        case 28: 
          { return symbol(sym.incr);
          }
        case 78: break;
        case 38: 
          { return symbol(sym.o);
          }
        case 79: break;
        case 46: 
          { return symbol(sym.pr_suma, (new Nodo(sym.pr_suma, "+", null, true)));
          }
        case 79: break;
        case 35: 
          { return symbol(sym.menor_igual);
          }
        case 80: break;
        case 5: 
          { return symbol(sym.prod);
          }
        case 81: break;
        case 40: 
          { return symbol(sym.cadena,  (new Nodo(sym.cadena, yytext(), yyline, yycolumn, null, true)));
          }
        case 82: break;
        case 57: 
          { return symbol(sym.pr_entero, (new Nodo(sym.pr_entero, yytext(), yyline, yycolumn, null, true)));
          }
        case 83: break;
        case 60: 
          { return symbol(sym.pr_selector);
          }
        case 84: break;
        case 25: 
          { return symbol(sym.a_div);
          }
        case 85: break;
        case 53: 
          { return symbol(sym.hexa_r, (new Nodo(sym.hexa_r, yytext(), yyline, yycolumn, null, true)));
          }
        case 86: break;
        case 16: 
          { return symbol(sym.neg);
          }
        case 87: break;
        case 1: 
          { return symbol(sym.id, (new Nodo(sym.id, yytext(), yyline, yycolumn, null, true)) );
          }
        case 88: break;
        case 6: 
          { return symbol(sym.par_ab);
          }
        case 89: break;
        case 21: 
          { return symbol(sym.cor_ab);
          }
        case 90: break;
        case 61: 
          { return symbol(sym.pr_retornar);
          }
        case 91: break;
        case 32: 
          { return symbol(sym.a_mod);
          }
        case 92: break;
        case 31: 
          { return symbol(sym.a_resta);
          }
        case 93: break;
        case 8: 
          { return symbol(sym.ll_ab);
          }
        case 94: break;
        case 20: 
          { return symbol(sym.sig_pun);
          }
        case 95: break;
        case 64: 
          { return symbol(sym.pr_principal);
          }
        case 96: break;
        case 26: 
          { return symbol(sym.a_prod);
          }
        case 97: break;
        case 46: 
          { return symbol(sym.pr_real, (new Nodo(sym.pr_real, yytext(), yyline, yycolumn, null, true)));
          }
        case 98: break;
        case 11: 
          { return symbol(sym.menos);
          }
        case 99: break;
        case 18: 
          { return symbol(sym.mayor);
          }
        case 100: break;
        case 47: 
          { return symbol(sym.pr_leer);
          }
        case 101: break;
        case 10: 
          { return symbol(sym.mas);
          }
        case 107: break;
        case 7: 
          { return symbol(sym.par_ab, (new Nodo(sym.par_ab, "+", null, true)));
          }
        case 102: break;
        case 13: 
          { return symbol(sym.transp);
          }
        case 103: break;
        case 51: 
          { return symbol(sym.pr_vacio, (new Nodo(sym.pr_vacio, yytext(), yyline, yycolumn, null, true)));
          }
        case 104: break;
        case 17: 
          { return symbol(sym.menor);
          }
        case 105: break;
        case 14: 
          { return symbol(sym.inv);
          }
        case 106: break;
        case 3: 
          { /* Ignorar */
          }
        case 107: break;
        case 66: 
          { return symbol(sym.pr_transp);
          }
        case 108: break;
        case 15: 
          { return symbol(sym.igual);
          }
        case 109: break;
        case 52: 
          { return symbol(sym.pr_resta);
          }
        case 110: break;
        case 62: 
          { return symbol(sym.pr_mientras);
          }
        case 111: break;
        case 29: 
          { return symbol(sym.a_suma);
          }
        case 112: break;
        case 65: 
          { return symbol(sym.pr_default);
          }
        case 113: break;
        case 59: 
          { return symbol(sym.pr_mostrar);
          }
        case 114: break;
        case 63: 
          { return symbol(sym.pr_prod);
          }
        case 115: break;
        case 19: 
          { return symbol(sym.sig_int);
          }
        case 116: break;
        case 34: 
          { return symbol(sym.dif);
          }
        case 117: break;
        case 54: 
          { return symbol(sym.pr_hacer);
          }
        case 118: break;
        case 36: 
          { return symbol(sym.mayor_igual);
          }
        case 119: break;
        case 7: 
          { return symbol(sym.par_ce);
          }
        case 120: break;
        case 22: 
          { return symbol(sym.cor_ce);
          }
        case 121: break;
        case 24: 
          { return symbol(sym.coma);
          }
        case 122: break;
        case 49: 
          { return symbol(sym.octa_r, (new Nodo(sym.octa_r, yytext(), yyline, yycolumn, null, true)));
          }
        case 123: break;
        case 2: 
          { return symbol(sym.numero, (new Nodo(sym.numero, yytext(), yyline, yycolumn, null, true)));
          }
        case 124: break;
        case 58: 
          { return symbol(sym.pr_inv);
          }
        case 125: break;
        case 41: 
          { return symbol(sym.real,  (new Nodo(sym.real, yytext(), yyline, yycolumn, null, true)));
          }
        case 126: break;
        case 33: 
          { return symbol(sym.ident);
          }
        case 127: break;
        case 55: 
          { return symbol(sym.pr_cadena, (new Nodo(sym.pr_cadena, yytext(), yyline, yycolumn, null, true)));
          }
        case 128: break;
        case 9: 
          { return symbol(sym.ll_ce);
          }
        case 129: break;
        case 56: 
          { return symbol(sym.pr_saltar);
          }
        case 130: break;
        case 50: 
          { return symbol(sym.pr_const,  (new Nodo(sym.pr_const, yytext(), yyline, yycolumn, null, true)));
          }
        case 131: break;
        case 4: 
          { return symbol(sym.div);
          }
        case 132: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
