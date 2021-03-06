/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.maven_webmail.model;

import cse.maven_webmail.control.CommandType;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jongmin
 */
public class MessageFormatter {

    private String userid;  // 파일 임시 저장 디렉토리 생성에 필요
    private HttpServletRequest request = null;

    public MessageFormatter(String userid) {
        this.userid = userid;
    }

// 메인화면 테이블 -------------------------
    public String getMessageTable(Message[] alignedMessages) {
        StringBuilder buffer = new StringBuilder();

        // 메시지 제목 보여주기
        buffer.append("<table>");  // table start
        buffer.append("<tr> "
                + " <th> No. </td> "
                + " <th> 보낸 사람 </td>"
                + " <th> 제목 </td>     "
                + " <th> 보낸 날짜 </td>   "
                + " <th> 삭제 </td>   "
                + " <th> 즐겨찾기</td>   "
                + " </tr>");

        for (int i = alignedMessages.length - 1; i >= 0; i--) {
            MessageParser parser = new MessageParser(alignedMessages[i], userid);
            parser.parse(false);  // envelope 정보만 필요
            // 메시지 헤더 포맷
            // 추출한 정보를 출력 포맷 사용하여 스트링으로 만들기
            buffer.append("<tr> "
                    + " <td id=no>" + (i + 1) + " </td> "
                    + " <td id=sender>" + parser.getFromAddress() + "</td>"
                    + " <td id=subject> "
                    + " <a href=show_message.jsp?msgid=" + (i + 1) + " title=\"메일 보기\"> "
                    + parser.getSubject() + "</a> </td>"
                    + " <td id=date>" + parser.getSentDate() + "</td>"
                    + " <td id=move>"
                    + "<a href=ReadMail.do?menu="
                    + CommandType.MAIL_REMOVE_COMMAND //-----------//
                    + "&msgid=" + (i + 1) + "> 휴지통 </a>" + "</td>"
                    + " <td id=setBookmarking>"
                    + "<a href=ReadMail.do?menu="
                    + CommandType.SET_BOOKMARK //-----------//
                    + "&msgid=" + (i + 1) + "> 설정 </a>" + "</td>"
                    + " </tr>");
        }
        buffer.append("</table>");

        return buffer.toString();
//        return "MessageFormatter 테이블 결과";
    }

    //-------------------------
    // trash_can.jsp 파일로 delete 플래그가
    //꽂힌 메일만을 보여주어야하는 테이블. 여기서 완전삭제 가능!
    /*  public String get_TMessageTable(Message[] messages) {
        StringBuilder buffer = new StringBuilder();

        // 메시지 제목 보여주기
        buffer.append("<table>");  // table start
        buffer.append("<tr> "
                + " <th> No. </td> "
                + " <th> 보낸 사람 </td>"
                + " <th> 제목 </td>     "
                + " <th> 보낸 날짜 </td>   "
                + " <th> 삭제 </td>   "
                + " </tr>");

        for (int i = messages.length - 1; i >= 0; i--) {
            MessageParser parser = new MessageParser(messages[i], userid);
            parser.parse(false);  // envelope 정보만 필요
            // 메시지 헤더 포맷
            // 추출한 정보를 출력 포맷 사용하여 스트링으로 만들기
            buffer.append("<tr> "
                    + " <td id=no>" + (i + 1) + " </td> "
                    + " <td id=sender>" + parser.getFromAddress() + "</td>"
                    + " <td id=subject> "
                    + " <a href=show_message.jsp?msgid=" + (i + 1) + " title=\"메일 보기\"> "
                    + parser.getSubject() + "</a> </td>"
                    + " <td id=date>" + parser.getSentDate() + "</td>"
                    + " <td id=delete>"
                    + "<a href=ReadMail.do?menu="
                    + CommandType.DELETE_MAIL_COMMAND //완전삭제-//
                    + "&msgid=" + (i + 1) + "> 완전삭제 </a>" + "</td>"
                    + " </tr>");
        }
        buffer.append("</table>");

        return buffer.toString();
//        return "MessageFormatter 테이블 결과";
    }
     */
    public String getBookmarkedMessageTable(ArrayList<Message> bookmarkedMessages) {
        BookmarkMessageAgent bookmarkMessageAgent = BookmarkMessageAgent.getInstance();
        ArrayList<Integer> msgIdList = bookmarkMessageAgent.getMsgIdList();
        StringBuilder buffer = new StringBuilder();

        // 메시지 제목 보여주기
        buffer.append("<table>");  // table start
        buffer.append("<tr> "
                + " <th> No. </td> "
                + " <th> 보낸 사람 </td>"
                + " <th> 제목 </td>     "
                + " <th> 보낸 날짜 </td>   "
                + " <th> 메일삭제 </td>   "
                + " <th> 즐겨찾기</td>   "
                + " </tr>");

        for (int i = bookmarkedMessages.size() - 1; i >= 0; i--) {

            try {
                MessageParser parser = new MessageParser(bookmarkedMessages.get(i), userid);
                parser.parse(false);  // envelope 정보만 필요
                // 메시지 헤더 포맷
                // 추출한 정보를 출력 포맷 사용하여 스트링으로 만들기
                buffer.append("<tr> "
                        + " <td id=no>" + msgIdList.get(i) + " </td> "
                        + " <td id=sender>" + parser.getFromAddress() + "</td>"
                        + " <td id=subject> "
                        + " <a href=show_message.jsp?msgid=" + msgIdList.get(i) + " title=\"메일 보기\"> "
                        + parser.getSubject() + "</a> </td>"
                        + " <td id=date>" + parser.getSentDate() + "</td>"
                        + " <td id=delete>"
                        + "<a href=ReadMail.do?menu="
                        + CommandType.DELETE_MAIL_COMMAND_IN_BOOKMARK //-----------//
                        + "&msgid=" + msgIdList.get(i) + "> 삭제 </a>" + "</td>"
                        + " <td id=cancelBookmarking>"
                        + "<a href=ReadMail.do?menu="
                        + CommandType.CANCLE_BOOKMARK //-----------//
                        + "&msgid=" + msgIdList.get(i) + "> 취소 </a>" + "</td>"
                        + " </tr>");
                //    buffer.append(i + " : " + messages[i].getFlags().contains("bookmarked") + "<br>");
                /* } else {
                    //로깅처리
                }*/

            } catch (Exception ex) {
                Logger.getLogger(MessageFormatter.class.getName()).log(Level.FINE, null, ex);
                buffer.append("<br><h1>" + ex + "</h1><br>");
            }
            System.out.println(Integer.toString(i) + " :                                                       trying to get messages ");

        }
        buffer.append("</table>");
        return buffer.toString();
    }

    public String getSpammedMessageTable(ArrayList<Message> messages) {
        SpamMessageAgent spamMessageAgent = SpamMessageAgent.getInstance();
        ArrayList<Integer> msgIdList = spamMessageAgent.getMsgIdList();

        StringBuilder buffer = new StringBuilder();

        // 메시지 제목 보여주기
        buffer.append("<table>");  // table start
        buffer.append("<tr> "
                + " <th> No. </td> "
                + " <th> 보낸 사람 </td>" 
                + " <th> 제목 </td>     "
                + " <th> 보낸 날짜 </td>   "
                + " <th> 메일삭제 </td>   "
                + " </tr>");

        for (int i = messages.size() - 1; i >= 0; i--) {

            try {
                MessageParser parser = new MessageParser(messages.get(i), userid);
                parser.parse(false);  // envelope 정보만 필요
                // 메시지 헤더 포맷
                // 추출한 정보를 출력 포맷 사용하여 스트링으로 만들기
                buffer.append("<tr> "
                        + " <td id=no>" + (msgIdList.get(i)) + " </td> "
                        + " <td id=sender>" + parser.getFromAddress() + "</td>"
                        + " <td id=subject> "
                        + " <a href=show_message.jsp?msgid=" + msgIdList.get(i) + " title=\"메일 보기\"> "
                        + parser.getSubject() + "</a> </td>"
                        + " <td id=date>" + parser.getSentDate() + "</td>"
                        + " <td id=delete>"
                        + "<a href=ReadMail.do?menu="
                        + CommandType.DELETE_MAIL_COMMAND_IN_SPAM //-----------//
                        + "&msgid=" + msgIdList.get(i) + "> 삭제 </a>" + "</td>"
                        + " </tr>");
            } catch (Exception ex) {
                Logger.getLogger(MessageFormatter.class.getName()).log(Level.FINE, null, ex);
                buffer.append("<br><h1>" + ex + "</h1><br>");
            }
            System.out.println(Integer.toString(i) + " :                                                       trying to get messages ");

        }
        buffer.append("</table>");
        return buffer.toString();
    }

    public String getMessage(Message message) {
        StringBuilder buffer = new StringBuilder();

        // MessageParser parser = new MessageParser(message, userid);
        MessageParser parser = new MessageParser(message, userid, request);
        parser.parse(true);

        buffer.append("보낸 사람: " + parser.getFromAddress() + " <br>");
        buffer.append("받은 사람: " + parser.getToAddress() + " <br>");
        buffer.append("Cc &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : " + parser.getCcAddress() + " <br>");
        buffer.append("보낸 날짜: " + parser.getSentDate() + " <br>");
        buffer.append("제 &nbsp;&nbsp;&nbsp;  목: " + parser.getSubject() + " <br> <hr>");

        buffer.append(parser.getBody());
       
        for (String attachedFile : parser.getFilenames().split("\\?")) {
            if (attachedFile != null) {
                buffer.append("<br> <hr> 첨부파일: <a href=ReadMail.do?menu="
                        + CommandType.DOWNLOAD_COMMAND
                        + "&userid=" + this.userid
                        + "&filename=" + attachedFile.replaceAll(" ", "%20")
                        + " target=_top> " + attachedFile + "</a> <br>");
            }
        }
        return buffer.toString();

    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

}
