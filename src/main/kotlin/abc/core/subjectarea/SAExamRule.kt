package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SAExamRule:Entity{
    var SADiscipline:EntityLink<SADiscipline> = EntityLink<SADiscipline>()
    var themes:EntityLinkList<SATheme> = EntityLinkList<SATheme>()
    var minimalRating:Int=0
    var examOwnRating:Int=0
    var examDuration:Int=0
    var oneQuestionDefBall:Int=0
    var oneExcerciceDefBall:Int=0
    var questionRating:Int=0
    var excerciceRating:Int=0
    var name:String=""
    var comment:String=""
    constructor() {}
}
