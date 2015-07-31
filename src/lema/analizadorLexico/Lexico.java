/* The following code was generated by JFlex 1.4.3 on 30/07/15 11:09 PM */

package lema.analizadorLexico;

import java_cup.runtime.*;
import lema.analizadorSemantico.Nodo;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 30/07/15 11:09 PM from the specification file
 * <tt>I:/CO/Software/LeMa 1.7/LeMa/src/lema/analizadorLexico/lexico.flex</tt>
 */
public class Lexico implements java_cup.runtime.Scanner {

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
    "\11\0\1\5\1\10\2\0\1\5\22\0\1\5\1\42\1\56\2\0"+
    "\1\33\1\45\1\34\1\25\1\26\1\7\1\31\1\60\1\32\1\54"+
    "\1\6\1\53\7\4\2\2\1\50\1\57\1\43\1\41\1\44\1\47"+
    "\1\0\6\3\24\1\1\51\1\0\1\52\1\35\1\1\1\0\1\17"+
    "\1\1\1\11\1\24\1\21\1\62\1\1\1\61\1\20\2\1\1\23"+
    "\1\37\1\13\1\12\1\40\1\1\1\22\1\14\1\15\1\36\1\16"+
    "\1\1\1\55\2\1\1\27\1\46\1\30\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\10\2"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\2\2\1\20\1\21\1\22\1\23\2\1\1\24"+
    "\1\25\1\26\1\27\1\3\1\1\1\30\1\31\1\2"+
    "\1\0\1\4\1\0\1\32\1\33\3\2\1\34\10\2"+
    "\1\35\1\36\1\37\1\40\1\41\5\2\1\42\1\43"+
    "\1\44\1\45\1\46\1\47\1\50\2\0\1\51\1\2"+
    "\1\52\1\0\25\2\1\0\1\53\2\2\1\54\2\2"+
    "\1\55\1\2\1\56\6\2\1\57\1\60\3\2\1\61"+
    "\2\2\1\62\1\0\1\2\1\63\4\2\1\64\2\2"+
    "\1\65\6\2\1\66\1\67\1\70\1\71\3\2\1\72"+
    "\10\2\1\73\1\2\1\74\4\2\1\75\1\2\1\76"+
    "\1\77\1\2\1\100\3\2\1\101\1\2\1\102\1\103";

  private static int [] zzUnpackAction() {
    int [] result = new int[180];
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
    "\0\0\0\63\0\146\0\231\0\63\0\314\0\377\0\u0132"+
    "\0\u0165\0\u0198\0\u01cb\0\u01fe\0\u0231\0\u0264\0\u0297\0\63"+
    "\0\63\0\63\0\63\0\u02ca\0\u02fd\0\u0330\0\63\0\63"+
    "\0\u0363\0\u0396\0\u03c9\0\u03fc\0\u042f\0\u0462\0\u0495\0\u04c8"+
    "\0\63\0\63\0\63\0\63\0\u04fb\0\u052e\0\63\0\63"+
    "\0\u0561\0\u0594\0\u05c7\0\u05fa\0\63\0\63\0\u062d\0\u0660"+
    "\0\u0693\0\u06c6\0\u06f9\0\u072c\0\u075f\0\u0792\0\u07c5\0\u07f8"+
    "\0\u082b\0\u085e\0\63\0\63\0\63\0\63\0\63\0\u0891"+
    "\0\u08c4\0\u08f7\0\u092a\0\u095d\0\63\0\63\0\63\0\63"+
    "\0\63\0\63\0\u0990\0\u09c3\0\u052e\0\63\0\u09f6\0\u0594"+
    "\0\u0a29\0\u0a5c\0\u0a8f\0\u0ac2\0\u0af5\0\u0b28\0\u0b5b\0\u0b8e"+
    "\0\u0bc1\0\u0bf4\0\u0c27\0\u0c5a\0\u0c8d\0\u0cc0\0\u0cf3\0\u0d26"+
    "\0\u0d59\0\u0d8c\0\u0dbf\0\u0df2\0\u0e25\0\u0e58\0\u0e8b\0\u0ebe"+
    "\0\u0ef1\0\u0f24\0\146\0\u0f57\0\u0f8a\0\146\0\u0fbd\0\146"+
    "\0\u0ff0\0\u1023\0\u1056\0\u1089\0\u10bc\0\u10ef\0\146\0\146"+
    "\0\u1122\0\u1155\0\u1188\0\146\0\u11bb\0\u11ee\0\u0e8b\0\u1221"+
    "\0\u1254\0\146\0\u1287\0\u12ba\0\u12ed\0\u1320\0\146\0\u1353"+
    "\0\u1386\0\146\0\u13b9\0\u13ec\0\u141f\0\u1452\0\u1485\0\u14b8"+
    "\0\u1221\0\146\0\146\0\146\0\u14eb\0\u151e\0\u1551\0\146"+
    "\0\u1584\0\u15b7\0\u15ea\0\u161d\0\u1650\0\u1683\0\u16b6\0\u16e9"+
    "\0\146\0\u171c\0\146\0\u174f\0\u1782\0\u17b5\0\u17e8\0\146"+
    "\0\u181b\0\146\0\146\0\u184e\0\146\0\u1881\0\u18b4\0\u18e7"+
    "\0\146\0\u191a\0\146\0\146";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[180];
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
    "\1\2\1\3\1\4\1\3\1\4\1\5\1\6\1\7"+
    "\1\5\1\10\2\3\1\11\1\12\1\13\1\3\1\14"+
    "\1\15\1\16\1\17\1\3\1\20\1\21\1\22\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\3\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\43\1\44\1\45\1\2\1\3\1\46\1\47\1\50"+
    "\1\51\1\3\64\0\4\3\4\0\14\3\11\0\3\3"+
    "\12\0\1\3\1\0\1\3\3\0\2\3\2\0\1\4"+
    "\1\0\1\4\46\0\1\4\1\52\14\0\1\53\1\54"+
    "\31\0\1\55\62\0\1\56\22\0\4\3\4\0\1\3"+
    "\1\57\4\3\1\60\5\3\11\0\3\3\12\0\1\3"+
    "\1\0\1\3\3\0\2\3\1\0\4\3\4\0\6\3"+
    "\1\61\1\62\1\63\3\3\11\0\1\64\2\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\11\3\1\65\2\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\6\3\1\66"+
    "\5\3\11\0\3\3\12\0\1\3\1\0\1\3\3\0"+
    "\2\3\1\0\4\3\4\0\2\3\1\67\11\3\11\0"+
    "\3\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\2\3\1\70\11\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\10\3\1\71\3\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\10\3\1\72"+
    "\3\3\11\0\3\3\12\0\1\3\1\0\1\3\3\0"+
    "\2\3\31\0\1\73\7\0\1\74\53\0\1\75\6\0"+
    "\1\76\62\0\1\77\22\0\4\3\4\0\1\3\1\100"+
    "\5\3\1\101\4\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\1\3\1\102"+
    "\4\3\1\103\2\3\1\104\2\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\41\0\1\105\62\0"+
    "\1\106\62\0\1\107\62\0\1\110\66\0\1\111\63\0"+
    "\1\112\16\0\1\4\1\0\1\113\46\0\1\113\1\52"+
    "\1\114\5\0\10\115\1\0\45\115\1\116\4\115\1\0"+
    "\4\3\4\0\6\3\1\117\5\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\2\0\1\120\1\0"+
    "\1\120\46\0\1\120\7\0\10\53\1\0\52\53\7\54"+
    "\1\121\53\54\1\0\4\3\4\0\2\3\1\122\11\3"+
    "\11\0\3\3\12\0\1\3\1\0\1\3\3\0\2\3"+
    "\1\0\4\3\4\0\3\3\1\123\7\3\1\124\11\0"+
    "\3\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\12\3\1\125\1\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\2\3\1\126\11\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\12\3\1\127"+
    "\1\3\11\0\3\3\12\0\1\3\1\0\1\3\3\0"+
    "\2\3\1\0\4\3\4\0\14\3\11\0\1\3\1\130"+
    "\1\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\6\3\1\131\5\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\1\132\13\3\11\0\3\3\12\0\1\3\1\0\1\3"+
    "\3\0\2\3\1\0\4\3\4\0\5\3\1\133\6\3"+
    "\11\0\3\3\12\0\1\3\1\0\1\3\3\0\2\3"+
    "\1\0\4\3\4\0\4\3\1\134\7\3\11\0\3\3"+
    "\12\0\1\3\1\0\1\3\3\0\2\3\1\0\4\3"+
    "\4\0\3\3\1\135\1\136\1\3\1\137\5\3\11\0"+
    "\3\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\10\3\1\140\3\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\3\3\1\141\10\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\10\3\1\142"+
    "\3\3\11\0\3\3\12\0\1\3\1\0\1\3\3\0"+
    "\2\3\1\0\4\3\4\0\11\3\1\143\2\3\11\0"+
    "\3\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\11\3\1\144\2\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\1\3\1\145\5\3\1\146\4\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\2\0\1\4\1\0"+
    "\1\113\46\0\1\113\1\147\10\0\3\150\46\0\1\150"+
    "\10\0\4\3\4\0\1\151\13\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\6\54\1\5\1\121"+
    "\53\54\1\0\4\3\4\0\3\3\1\152\10\3\11\0"+
    "\3\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\1\3\1\153\12\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\10\3\1\154\3\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\4\3\1\155"+
    "\7\3\11\0\3\3\12\0\1\3\1\0\1\3\3\0"+
    "\2\3\1\0\4\3\4\0\1\3\1\156\12\3\11\0"+
    "\3\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\10\3\1\157\3\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\6\3\1\160\5\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\2\3\1\161"+
    "\11\3\11\0\3\3\12\0\1\3\1\0\1\3\3\0"+
    "\2\3\1\0\4\3\4\0\7\3\1\162\4\3\11\0"+
    "\3\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\10\3\1\163\3\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\10\3\1\164\3\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\4\3\1\165"+
    "\7\3\11\0\3\3\12\0\1\3\1\0\1\3\3\0"+
    "\2\3\1\0\4\3\4\0\1\3\1\166\12\3\11\0"+
    "\3\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\12\3\1\167\1\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\11\3\1\170\2\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\4\3\1\171"+
    "\7\3\11\0\3\3\12\0\1\3\1\0\1\3\3\0"+
    "\2\3\1\0\4\3\4\0\2\3\1\172\11\3\11\0"+
    "\3\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\13\3\1\173\11\0\3\3\12\0\1\3"+
    "\1\0\1\3\3\0\2\3\1\0\4\3\4\0\6\3"+
    "\1\174\5\3\11\0\3\3\12\0\1\3\1\0\1\3"+
    "\3\0\2\3\1\0\4\3\4\0\13\3\1\175\11\0"+
    "\3\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\2\3\1\176\11\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\2\0\1\120\1\0"+
    "\1\177\46\0\1\177\11\0\3\150\46\0\1\150\1\200"+
    "\7\0\4\3\4\0\10\3\1\201\3\3\11\0\3\3"+
    "\12\0\1\3\1\0\1\3\3\0\2\3\1\0\4\3"+
    "\4\0\4\3\1\202\7\3\11\0\3\3\12\0\1\3"+
    "\1\0\1\3\3\0\2\3\1\0\4\3\4\0\2\3"+
    "\1\203\11\3\11\0\3\3\12\0\1\3\1\0\1\3"+
    "\3\0\2\3\1\0\4\3\4\0\6\3\1\204\5\3"+
    "\11\0\3\3\12\0\1\3\1\0\1\3\3\0\2\3"+
    "\1\0\4\3\4\0\1\205\13\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\3\3\1\206\10\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\1\3\1\207"+
    "\12\3\11\0\3\3\12\0\1\3\1\0\1\3\3\0"+
    "\2\3\1\0\4\3\4\0\11\3\1\210\2\3\11\0"+
    "\3\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\11\3\1\211\2\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\6\3\1\212\5\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\11\3\1\213"+
    "\2\3\11\0\3\3\12\0\1\3\1\0\1\3\3\0"+
    "\2\3\1\0\4\3\4\0\11\3\1\214\2\3\11\0"+
    "\3\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\4\3\1\215\7\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\10\3\1\216\3\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\14\3\11\0"+
    "\1\217\2\3\12\0\1\3\1\0\1\3\3\0\2\3"+
    "\1\0\4\3\4\0\1\220\13\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\2\0\3\221\46\0"+
    "\1\221\10\0\4\3\4\0\11\3\1\222\2\3\11\0"+
    "\3\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\6\3\1\223\5\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\11\3\1\224\2\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\4\3\1\225"+
    "\7\3\11\0\3\3\12\0\1\3\1\0\1\3\3\0"+
    "\2\3\1\0\4\3\4\0\14\3\11\0\2\3\1\226"+
    "\12\0\1\3\1\0\1\3\3\0\2\3\1\0\4\3"+
    "\4\0\3\3\1\227\10\3\11\0\3\3\12\0\1\3"+
    "\1\0\1\3\3\0\2\3\1\0\4\3\4\0\1\3"+
    "\1\230\12\3\11\0\3\3\12\0\1\3\1\0\1\3"+
    "\3\0\2\3\1\0\4\3\4\0\2\3\1\231\11\3"+
    "\11\0\3\3\12\0\1\3\1\0\1\3\3\0\2\3"+
    "\1\0\4\3\4\0\6\3\1\232\5\3\11\0\3\3"+
    "\12\0\1\3\1\0\1\3\3\0\2\3\1\0\4\3"+
    "\4\0\11\3\1\233\2\3\11\0\3\3\12\0\1\3"+
    "\1\0\1\3\3\0\2\3\1\0\4\3\4\0\14\3"+
    "\11\0\3\3\12\0\1\3\1\0\1\3\3\0\1\3"+
    "\1\234\1\0\4\3\4\0\1\235\13\3\11\0\3\3"+
    "\12\0\1\3\1\0\1\3\3\0\2\3\1\0\4\3"+
    "\4\0\7\3\1\236\4\3\11\0\3\3\12\0\1\3"+
    "\1\0\1\3\3\0\2\3\1\0\4\3\4\0\1\3"+
    "\1\237\12\3\11\0\3\3\12\0\1\3\1\0\1\3"+
    "\3\0\2\3\1\0\4\3\4\0\14\3\11\0\1\240"+
    "\2\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\6\3\1\241\5\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\6\3\1\242\5\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\11\3\1\243"+
    "\2\3\11\0\3\3\12\0\1\3\1\0\1\3\3\0"+
    "\2\3\1\0\4\3\4\0\6\3\1\244\5\3\11\0"+
    "\3\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\10\3\1\245\3\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\4\3\1\246\7\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\14\3\11\0"+
    "\2\3\1\247\12\0\1\3\1\0\1\3\3\0\2\3"+
    "\1\0\4\3\4\0\11\3\1\250\2\3\11\0\3\3"+
    "\12\0\1\3\1\0\1\3\3\0\2\3\1\0\4\3"+
    "\4\0\10\3\1\251\3\3\11\0\3\3\12\0\1\3"+
    "\1\0\1\3\3\0\2\3\1\0\4\3\4\0\11\3"+
    "\1\252\2\3\11\0\3\3\12\0\1\3\1\0\1\3"+
    "\3\0\2\3\1\0\4\3\4\0\3\3\1\253\10\3"+
    "\11\0\3\3\12\0\1\3\1\0\1\3\3\0\2\3"+
    "\1\0\4\3\4\0\1\254\13\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\1\3\1\255\12\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\6\3\1\256"+
    "\5\3\11\0\3\3\12\0\1\3\1\0\1\3\3\0"+
    "\2\3\1\0\4\3\4\0\3\3\1\257\10\3\11\0"+
    "\3\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\4\3\1\260\7\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3\1\0\4\3\4\0"+
    "\12\3\1\261\1\3\11\0\3\3\12\0\1\3\1\0"+
    "\1\3\3\0\2\3\1\0\4\3\4\0\4\3\1\262"+
    "\7\3\11\0\3\3\12\0\1\3\1\0\1\3\3\0"+
    "\2\3\1\0\4\3\4\0\1\3\1\263\12\3\11\0"+
    "\3\3\12\0\1\3\1\0\1\3\3\0\2\3\1\0"+
    "\4\3\4\0\6\3\1\264\5\3\11\0\3\3\12\0"+
    "\1\3\1\0\1\3\3\0\2\3";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6477];
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
    "\1\0\1\11\2\1\1\11\12\1\4\11\3\1\2\11"+
    "\10\1\4\11\2\1\2\11\1\1\1\0\1\1\1\0"+
    "\2\11\14\1\5\11\5\1\6\11\1\1\2\0\1\11"+
    "\2\1\1\0\25\1\1\0\30\1\1\0\64\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[180];
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
  public Lexico(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Lexico(java.io.InputStream in) {
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
    while (i < 134) {
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
        case 38: 
          { return symbol(sym.y);
          }
        case 68: break;
        case 49: 
          { return symbol(sym.pr_para);
          }
        case 69: break;
        case 31: 
          { return symbol(sym.decr);
          }
        case 70: break;
        case 46: 
          { return symbol(sym.pr_suma);
          }
        case 71: break;
        case 13: 
          { return symbol(sym.mod);
          }
        case 72: break;
        case 24: 
          { return symbol(sym.punto_coma);
          }
        case 73: break;
        case 3: 
          { return symbol(sym.numero,     (new Nodo(sym.numero, yytext(), yyline, yycolumn, null, true)));
          }
        case 74: break;
        case 44: 
          { return symbol(sym.pr_caso);
          }
        case 75: break;
        case 47: 
          { return symbol(sym.pr_real,  (new Nodo(sym.pr_real, yytext(), yyline, yycolumn, null, true)));
          }
        case 76: break;
        case 45: 
          { return symbol(sym.pr_sino);
          }
        case 77: break;
        case 28: 
          { return symbol(sym.pr_si);
          }
        case 78: break;
        case 29: 
          { return symbol(sym.incr);
          }
        case 79: break;
        case 39: 
          { return symbol(sym.o);
          }
        case 80: break;
        case 52: 
          { return symbol(sym.pr_vacio,   (new Nodo(sym.pr_vacio, yytext(), yyline, yycolumn, null, true)));
          }
        case 81: break;
        case 36: 
          { return symbol(sym.menor_igual);
          }
        case 82: break;
        case 6: 
          { return symbol(sym.prod);
          }
        case 83: break;
        case 58: 
          { return symbol(sym.pr_entero, (new Nodo(sym.pr_entero, yytext(), yyline, yycolumn, null, true)));
          }
        case 84: break;
        case 61: 
          { return symbol(sym.pr_selector);
          }
        case 85: break;
        case 26: 
          { return symbol(sym.a_div);
          }
        case 86: break;
        case 17: 
          { return symbol(sym.neg);
          }
        case 87: break;
        case 7: 
          { return symbol(sym.par_ab);
          }
        case 88: break;
        case 22: 
          { return symbol(sym.cor_ab);
          }
        case 89: break;
        case 62: 
          { return symbol(sym.pr_retornar);
          }
        case 90: break;
        case 33: 
          { return symbol(sym.a_mod);
          }
        case 91: break;
        case 32: 
          { return symbol(sym.a_resta);
          }
        case 92: break;
        case 9: 
          { return symbol(sym.ll_ab);
          }
        case 93: break;
        case 21: 
          { return symbol(sym.sig_pun);
          }
        case 94: break;
        case 65: 
          { return symbol(sym.pr_principal);
          }
        case 95: break;
        case 27: 
          { return symbol(sym.a_prod);
          }
        case 96: break;
        case 12: 
          { return symbol(sym.menos);
          }
        case 97: break;
        case 19: 
          { return symbol(sym.mayor);
          }
        case 98: break;
        case 48: 
          { return symbol(sym.pr_leer);
          }
        case 99: break;
        case 40: 
          { return symbol(sym.octa_e,     (new Nodo(sym.octa_e, yytext(), yyline, yycolumn, null, true)));
          }
        case 100: break;
        case 11: 
          { return symbol(sym.mas);
          }
        case 101: break;
        case 51: 
          { return symbol(sym.pr_const);
          }
        case 102: break;
        case 14: 
          { return symbol(sym.transp);
          }
        case 103: break;
        case 18: 
          { return symbol(sym.menor);
          }
        case 104: break;
        case 42: 
          { return symbol(sym.real,       (new Nodo(sym.real, yytext(), yyline, yycolumn, null, true)));
          }
        case 105: break;
        case 15: 
          { return symbol(sym.inv);
          }
        case 106: break;
        case 4: 
          { /* Ignorar */
          }
        case 107: break;
        case 67: 
          { return symbol(sym.pr_transp);
          }
        case 108: break;
        case 16: 
          { return symbol(sym.igual);
          }
        case 109: break;
        case 1: 
          { return symbol(sym.err, yytext());
          }
        case 110: break;
        case 53: 
          { return symbol(sym.pr_resta);
          }
        case 111: break;
        case 43: 
          { return symbol(sym.hexa_e,     (new Nodo(sym.hexa_e, yytext(), yyline, yycolumn, null, true)));
          }
        case 112: break;
        case 63: 
          { return symbol(sym.pr_mientras);
          }
        case 113: break;
        case 30: 
          { return symbol(sym.a_suma);
          }
        case 114: break;
        case 66: 
          { return symbol(sym.pr_default);
          }
        case 115: break;
        case 60: 
          { return symbol(sym.pr_mostrar);
          }
        case 116: break;
        case 64: 
          { return symbol(sym.pr_prod);
          }
        case 117: break;
        case 20: 
          { return symbol(sym.sig_int);
          }
        case 118: break;
        case 50: 
          { return symbol(sym.octa_r,     (new Nodo(sym.octa_r, yytext(), yyline, yycolumn, null, true)));
          }
        case 119: break;
        case 35: 
          { return symbol(sym.dif);
          }
        case 120: break;
        case 55: 
          { return symbol(sym.pr_hacer);
          }
        case 121: break;
        case 37: 
          { return symbol(sym.mayor_igual);
          }
        case 122: break;
        case 8: 
          { return symbol(sym.par_ce);
          }
        case 123: break;
        case 23: 
          { return symbol(sym.cor_ce);
          }
        case 124: break;
        case 25: 
          { return symbol(sym.coma);
          }
        case 125: break;
        case 41: 
          { return symbol(sym.cadena,     (new Nodo(sym.cadena, yytext(), yyline, yycolumn, null, true)));
          }
        case 126: break;
        case 59: 
          { return symbol(sym.pr_inv);
          }
        case 127: break;
        case 54: 
          { return symbol(sym.hexa_r,     (new Nodo(sym.hexa_r, yytext(), yyline, yycolumn, null, true)));
          }
        case 128: break;
        case 34: 
          { return symbol(sym.ident);
          }
        case 129: break;
        case 10: 
          { return symbol(sym.ll_ce);
          }
        case 130: break;
        case 57: 
          { return symbol(sym.pr_saltar);
          }
        case 131: break;
        case 56: 
          { return symbol(sym.pr_cadena,  (new Nodo(sym.pr_cadena, yytext(), yyline, yycolumn, null, true)));
          }
        case 132: break;
        case 2: 
          { return symbol(sym.id,         (new Nodo(sym.id, yytext(), yyline, yycolumn, null, true)) );
          }
        case 133: break;
        case 5: 
          { return symbol(sym.div);
          }
        case 134: break;
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
