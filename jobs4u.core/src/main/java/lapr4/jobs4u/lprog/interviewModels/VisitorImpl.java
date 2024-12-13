package lapr4.jobs4u.lprog.interviewModels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisitorImpl extends interviewModelBaseVisitor<Void> {

    private final Map<String, List<Answer>> mul = new HashMap<>();

    @Override
    public Void visitQtruefalse(interviewModelParser.QtruefalseContext ctx) {
        List<Answer> answer = new ArrayList<>();

        if (ctx.atruefalse() != null)
            answer.add(new Answer(ctx.atruefalse().rtruefalse().getText().toLowerCase(), getMark(ctx.atruefalse().mark())));

        mul.put(ctx.question().getText(), answer);

        return null;
    }

    @Override
    public Void visitQshorttextanswer(interviewModelParser.QshorttextanswerContext ctx) {

        List<Answer> answer = new ArrayList<>();

        if (ctx.ashorttextanswer() != null)
            answer.add(new Answer(ctx.ashorttextanswer().rshorttextanswer().getText().toLowerCase(), getMark(ctx.ashorttextanswer().mark())));

        mul.put(ctx.question().getText(), answer);

        return null;
    }

    @Override
    public Void visitQchoicesingle(interviewModelParser.QchoicesingleContext ctx) {
        List<Answer> answer = new ArrayList<>();

        if (ctx.achoicesingle() != null)
            answer.add(new Answer(ctx.achoicesingle().rchoicesingle().getText(), getMark(ctx.achoicesingle().mark())));

        mul.put(ctx.question().getText(), answer);

        return null;
    }


    @Override
    public Void visitQchoicemultiple(interviewModelParser.QchoicemultipleContext ctx) {
        String question = ctx.question().getText();
        List<String> answersS = new ArrayList<>();
        List<Integer> marks = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();

        if (ctx.achoicemultiple() != null) {
            for (interviewModelParser.RchoicemultipleContext answerCtx : ctx.achoicemultiple().rchoicemultiple())
                answersS.add(answerCtx.getText());

            for (interviewModelParser.MarkContext answerCtx : ctx.achoicemultiple().mark())
                marks.add(getMark(answerCtx));
        }

        if (marks.isEmpty()) {
            for (String s : answersS) {
                answers.add(new Answer(s));
            }
        } else {
            for (int i = 0; i < answersS.size(); i++) {
                answers.add(new Answer(answersS.get(i), marks.get(i)));
            }
        }

        mul.put(question, answers);

        return null;
    }


    @Override
    public Void visitQintegernumber(interviewModelParser.QintegernumberContext ctx) {
        List<Answer> answer = new ArrayList<>();

        if (ctx.aintegernumber() != null)
            answer.add(new Answer(ctx.aintegernumber().rintegernumber().getText(), getMark(ctx.aintegernumber().mark())));

        mul.put(ctx.question().getText(), answer);

        return null;
    }

    @Override
    public Void visitQdecimalnumber(interviewModelParser.QdecimalnumberContext ctx) {
        List<Answer> answer = new ArrayList<>();

        if (ctx.adecimalnumber() != null)
            answer.add(new Answer(ctx.adecimalnumber().rdecimalnumber().getText(), getMark(ctx.adecimalnumber().mark())));

        mul.put(ctx.question().getText(), answer);

        return null;
    }

    @Override
    public Void visitQdate(interviewModelParser.QdateContext ctx) {
        List<Answer> answer = new ArrayList<>();

        if (ctx.adate() != null)
            answer.add(new Answer(ctx.adate().rdate().getText(), getMark(ctx.adate().mark())));

        mul.put(ctx.question().getText(), answer);

        return null;
    }

    @Override
    public Void visitQtime(interviewModelParser.QtimeContext ctx) {
        List<Answer> answer = new ArrayList<>();

        if (ctx.atime() != null)
            answer.add(new Answer(ctx.atime().rtime().getText(), getMark(ctx.atime().mark())));

        mul.put(ctx.question().getText(), answer);

        return null;
    }

    @Override
    public Void visitQnumericscale(interviewModelParser.QnumericscaleContext ctx) {
        List<Answer> answer = new ArrayList<>();

        if (ctx.anumericscale() != null)
            answer.add(new Answer(ctx.anumericscale().rnumericscale().getText(), getMark(ctx.anumericscale().mark())));

        mul.put(ctx.question().getText(), answer);

        return null;
    }


    private Integer getMark(interviewModelParser.MarkContext ctx) {
        if (ctx != null) {
            return Integer.parseInt(ctx.getText());
        }
        return null;
    }


    public Map<String, List<Answer>> getMul() {
        return mul;
    }
}