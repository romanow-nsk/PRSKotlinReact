package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SADiscipline:Entity{
    var themes:ArrayList<SATheme> = ArrayList<SATheme>()
    var rules:ArrayList<SAExamRule> = ArrayList<SAExamRule>()
    var ratings:ArrayList<SAGroupRating> = ArrayList<SAGroupRating>()
    var takings:ArrayList<SAExamTaking> = ArrayList<SAExamTaking>()
    var units:ArrayList<SAEduUnit> = ArrayList<SAEduUnit>()
    var name:String=""
    var comment:String=""
    constructor() {}
}
