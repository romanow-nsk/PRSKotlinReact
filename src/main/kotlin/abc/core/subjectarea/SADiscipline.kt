package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SADiscipline:Entity{
    var themes:EntityRefList<SATheme> = EntityRefList<SATheme>()
    var rules:EntityRefList<SAExamRule> = EntityRefList<SAExamRule>()
    var ratings:EntityRefList<SAGroupRating> = EntityRefList<SAGroupRating>()
    var takings:EntityRefList<SAExamTaking> = EntityRefList<SAExamTaking>()
    var units:EntityRefList<SAEduUnit> = EntityRefList<SAEduUnit>()
    var name:String=""
    var comment:String=""
    constructor() {}
}
