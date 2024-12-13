package lapr4.jobs4u.lprog.requirementsSpecifications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequirementsListener extends requirementSpecificationBaseListener {

    private final Map<String, List<String>> mul = new HashMap<>();
    private final List<String> nonMul = new ArrayList<>();

    @Override
    public void enterReqOptionInt(requirementSpecificationParser.ReqOptionIntContext ctx) {
        if (ctx.ansOptionInt() != null)
            nonMul.add(ctx.ansOptionInt().getText());
        else nonMul.add("Did not Answer");
    }

    @Override
    public void enterReqOneOption(requirementSpecificationParser.ReqOneOptionContext ctx) {
        if (ctx.ansOneOption() != null)
            nonMul.add(ctx.ansOneOption().getText());
        else nonMul.add("Did not Answer");
    }

    @Override
    public void enterReqMultipleOption(requirementSpecificationParser.ReqMultipleOptionContext ctx) {

        String requirement = ctx.requirement().getText();

        List<String> answers = new ArrayList<>();

        for (requirementSpecificationParser.PhraseContext answer : ctx.ansMultipleOption().phrase()){
            answers.add(answer.getText());
        }

        mul.put(requirement, answers);

    }

    public Map<String, List<String>> getMul() {
        return mul;
    }

    public List<String> getNonMul() {
        return nonMul;
    }

}