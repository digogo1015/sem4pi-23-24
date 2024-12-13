grammar interviewModel;

@members {
    int totalMarks = 0;

    public int getTotalMarks() {
            return totalMarks;
        }
}



start: (questions? NEWLINE)+ ;

questions: qshorttextanswer
            | qchoicemultiple
            | qchoicesingle
            | qdate
            | qtruefalse
            | qtime
            | qintegernumber
            | qnumericscale
            | qdecimalnumber;

answers: ashorttextanswer
          | achoicemultiple
          | achoicesingle
          | adate
          | atruefalse
          | atime
          | aintegernumber
          | anumericscale
          | adecimalnumber;

qtruefalse : question '[TRUE/FALSE]' NEWLINE answerField (atruefalse)?;
atruefalse : (rtruefalse) ('-' mark)?;
rtruefalse : TK_TRUE | TK_FALSE;

qshorttextanswer : question '[LIMIT OF ANSWER SIZE: ' (TK_DIGIT+)+ ' CHARS]' NEWLINE answerField (ashorttextanswer)?;
ashorttextanswer : rshorttextanswer ('-' mark)?;
rshorttextanswer : phrase;

qchoicesingle : question '[SINGLE CHOICE]' NEWLINE choices NEWLINE answerField (achoicesingle)?;
achoicesingle : rchoicesingle ('-' mark)?;
rchoicesingle : TK_DIGIT+;

qchoicemultiple : question '[MULTIPLE CHOICE]' NEWLINE choices NEWLINE answerField (achoicemultiple)?;
achoicemultiple :  rchoicemultiple ('-' mark)? (',' rchoicemultiple ('-' mark)?)* ;
rchoicemultiple : TK_DIGIT+;

qintegernumber : question '[INTEGER ANSWER]' NEWLINE answerField (aintegernumber)?;
aintegernumber : rintegernumber ('-' mark)?;
rintegernumber : TK_DIGIT+;

qdecimalnumber : question '[DECIMAL ANSWER WITH TWO DECIMAL PLACES]' NEWLINE answerField (adecimalnumber)?;
adecimalnumber : rdecimalnumber ('-' mark)?;
rdecimalnumber : TK_DIGIT+ '.' TK_DIGIT TK_DIGIT;

qdate : question '[DATE ANSWER WITH FORMAT: DD/MM/YYYY]' NEWLINE answerField (adate)?;
adate : rdate ('-' mark)?;
rdate : TK_DATE;

qtime : question '[TIME ANSWER WITH FORMAT: hh:mm]' NEWLINE answerField (atime)?;
atime : rtime ('-' mark)?;
rtime : TK_TIME;

qnumericscale : question '[ANSWER BETWEEN:' (TK_DIGIT+)+ '-' (TK_DIGIT+)+ ']' NEWLINE answerField (anumericscale)?;
anumericscale : rnumericscale ('-' mark)?;
rnumericscale : TK_DIGIT+;

question : phrase '?' ;

phrase : (TK_TEXT | TK_DIGIT+) (WS? (TK_TEXT | TK_DIGIT+))*;

choices : (choiceNumber choice NEWLINE?)+ ;

choiceNumber : (TK_DIGIT+)+ '.';

choice : TK_TEXT;

answerField : phrase ':' ;

mark : TK_DIGIT+ { totalMarks += Integer.parseInt($TK_DIGIT.text); };

TK_TRUE  : [Tt][Rr][Uu][Ee] ;

TK_FALSE : [Ff][Aa][Ll][Ss][Ee] ;

TK_TEXT : TK_LETTER+;

TK_LETTER: [a-zA-Z];

TK_DIGIT : [0-9];

TK_DATE : TK_DIGIT TK_DIGIT '/' TK_DIGIT TK_DIGIT '/' TK_DIGIT TK_DIGIT TK_DIGIT TK_DIGIT;

TK_TIME : TK_DIGIT TK_DIGIT ':' TK_DIGIT TK_DIGIT;

TK_QUEST : '?' ;

NEWLINE : '\r'? '\n' ;

WS : [ \t]+ -> skip ;

TEXT : ',''-''('')'':'';''+' -> skip ;