grammar requirementSpecification;

start: (requirements? NEWLINE)+;

requirements: reqOptionInt
              |reqOneOption
              |reqMultipleOption;

answers: ansOptionInt
          |ansOneOption
          |ansMultipleOption;


reqOptionInt: requirement '(integer)' NEWLINE answerField (ansOptionInt)?;
ansOptionInt: TK_DIGIT+;

reqOneOption: requirement '(' choices ')' NEWLINE answerField (ansOneOption)?;
ansOneOption: phrase;

reqMultipleOption: requirement '(' choices ')' NEWLINE answerField (ansMultipleOption)?;
ansMultipleOption: phrase (', ' phrase)*;

phrase : (TK_TEXT|TK_DIGIT+) (WS? (TK_TEXT|TK_DIGIT+))*;

choices : phrase ('; ' phrase)*;

requirement : '# ' phrase;

answerField : phrase ':';

TK_TEXT : TK_LETTER+;

TK_LETTER: [a-zA-Z];

TK_DIGIT : [0-9];

NEWLINE:'\r'?'\n';

WS : [ \t]+ -> skip;

TEXT : ',''-''('')'':'';''+' -> skip;
