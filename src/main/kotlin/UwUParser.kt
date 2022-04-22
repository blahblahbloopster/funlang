import stdlib.UwUString

class UwUParser {
//    enum class Keyword(val uwuified: String) {
//        FUN("fuwn"), RETURN("wetuwn"), BREAK("bweak"), CONTINUE("continuwue"), IF("if"), ELSE("ewse"), LET("wet"), MUT("mewt"), WHILE("whiwe"), IMPORT("impowt"), STRUCT("stwuct"), STATIC("static")
//    }

//    data class DefinedVariable(val name: String, val type: UwUType)

    class UwUImport(val name: UwUName, val funName: String? = null) {
        override fun toString(): String {
            return name.names.joinToString(".")
        }
    }

//    data class Scope(val parents: List<Scope>, val variables: MutableList<DefinedVariable>, val imports: List<UwUImport>) {
//        val allVariables get() = parents.flatMap { it.variables } + variables
//    }

    /*

    To parse a file (multiple files can be copy/pasted together with some import fiddling):
    1. find struct and method bodies
      a. yeet string literals
      b. do brace matches
      c. profit
    2. instantiate structs with name and no fields
     a. for now use null constructor
    3. add fields to structs
    4. parse method bodies
     a. add each parsed method to the appropriate struct

    */

//    fun parseFile(inp: String) {
//        var str = inp
//
//        // TODO: number constants
//
//        val stringLiterals = findStrings(str)
//
//        for ((index, item) in stringLiterals.withIndex().reversed()) {
//            str = str.replaceRange(item.first, "%str$index")
//        }
//
//        val lines = inp.split(';').flatMap { it.replace("{", ";{;").replace("}", ";};").split(';') }.map { it.dropWhile { it.isWhitespace() }.dropLastWhile { it.isWhitespace() } }
//
//        val imports = lines.filter { it.startsWith(Keyword.IMPORT.uwuified + " ") }.map { it.substringAfterLast(' ') }
//
//        val structDeclarations = lines.filter { it.startsWith(Keyword.STRUCT.uwuified + " ") }.map { it.removePrefix(Keyword.STRUCT.uwuified + " ").substringBefore('{').dropLastWhile { it.isWhitespace() } }
//
//        data class ProtoMethod(val clsName: UwUName, val methodName: String, val isStatic: Boolean, val args: List<Pair<String, UwUType>>, val methodBody: String)
//
//        val methodDeclarations = mutableListOf<ProtoMethod>()
//
////        val methodStartRegex = "(${Keyword.STATIC.uwuified} )?(${Keyword.FUN.uwuified}) (\\w+\\.)+(\\w+)".toRegex()
//        val methodStarts = lines.withIndex().filter { (_, it) -> it.startsWith(Keyword.FUN.uwuified + " ") }
//        for (item in methodStarts) {
//            var braceCount = 0
//            var i = item.index
//            for (line in lines.drop(item.index)) {
//                if ('{' in line) braceCount++
//                if ('}' in line && --braceCount == 0) break
//                i++
//            }
//            val range = item.index + 1 until i
////            methodDeclarations.add(reprocess(lines.slice(range), stringLiterals.map { it.second }))
//        }
//
//        println("struct declarations: $structDeclarations")
//        println("imports: $imports")
//    }

//    sealed interface ScopeNode {
//        val children: List<ScopeNode>
//        val scope: Scope
//
//        fun exec(eScope: UwUInterpreter.ExecutionScope, interpreter: UwUInterpreter)
//
//        class StatementListNode(override val scope: Scope, override val children: List<ScopeNode>) : ScopeNode {
//            override fun exec(eScope: UwUInterpreter.ExecutionScope, interpreter: UwUInterpreter) {
//                children.forEach { it.exec(eScope, interpreter) }
//                eScope.freeVars()
//            }
//        }
//
//        class ExpressionNode(override val scope: Scope, val expression: UwUParser.ExpressionNode) : ScopeNode {
//            override val children: List<ScopeNode> = emptyList()
//
//            override fun exec(eScope: UwUInterpreter.ExecutionScope, interpreter: UwUInterpreter) {
//                interpreter.evaluateExpression(expression, eScope)
//            }
//        }
//
//        class VariableSetNode(override val scope: Scope, val variable: DefinedVariable, val expression: UwUParser.ExpressionNode) : ScopeNode {
//            override val children: List<ScopeNode> = emptyList()
//
//            override fun exec(eScope: UwUInterpreter.ExecutionScope, interpreter: UwUInterpreter) {
//                val newValue = interpreter.evaluateExpression(expression, eScope)
//
//                (newValue as? UwUObject.UwURef)?.let { eScope.addRoot(it) }
//                val existing = eScope.variables.find { it.name == variable.name }
//                (existing?.value as? UwUObject.UwURef)?.let { eScope.addRoot(it) }
//                if (existing != null) {
//                    existing.value = newValue
//                } else {
//                    eScope.variables.add(UwUInterpreter.UwUVar(variable.name, newValue))
//                }
//            }
//        }
//
//        class WhileLoopNode(override val scope: Scope, val condition: UwUParser.ExpressionNode, val block: StatementListNode) : ScopeNode {
//            override val children: List<ScopeNode> = listOf(/*todo: include condition?*/block)
//
//            private fun cond(eScope: UwUInterpreter.ExecutionScope, interpreter: UwUInterpreter): Boolean {
//                val value = interpreter.evaluateExpression(condition, eScope)
//                require(value.type == UwUPrimitive.UwUBoolean)
//                return (value as UwUObject.UwUStatic).value != 0L
//            }
//
//            override fun exec(eScope: UwUInterpreter.ExecutionScope, interpreter: UwUInterpreter) {
//                while (cond(eScope, interpreter)) {
//                    val subScope = UwUInterpreter.ExecutionScope(eScope, eScope.variables.toMutableList(), mutableSetOf())
//                    block.exec(subScope, interpreter)
//                }
//            }
//        }
//    }

    class CompilerError(cause: String) : Throwable(cause)

//    private fun findBracedAreaEnd(str: List<String>, start: Int): Int {
//        var count = 0
//        for ((index, item) in str.withIndex().drop(start)) {
//            if ('{' in item) count++
//            if ('}' in item) {
//                if (--count == 0) return index
//            }
//        }
//        throw CompilerError("Mismatched braces!")
//    }
//
//    private fun reprocess(lines: List<String>, stringConstants: List<String>): String {
//        var str = lines.joinToString(";\n")
//        for ((index, item) in stringConstants.withIndex()) {
//            str = str.replace("%str$index", "\"$item\"")  // TODO: re-escape
//        }
//        return str.replace("\n;", "")
//    }
//    private fun reprocessExpression(expr: String, stringConstants: List<String>, numberConstants: List<Number>): String {
//        var str = expr
//        for ((index, item) in stringConstants.withIndex()) {
//            str = str.replace("%str$index", "\"$item\"")  // TODO: re-escape
//        }
//        for ((index, item) in numberConstants.withIndex()) {
//            str = str.replace("%num$index", "$item")  // TODO: re-escape
//        }
//        return str
//    }
//
//    fun parse(scope: Scope, block: String): ScopeNode.StatementListNode {
//        var str = block
//        if (str.lowercase().contains("l") || str.lowercase().contains("r")) throw CompilerError("Pwogwam may not contain the wettews eww or aww!")
//        if (str.count { it == 'w' || it == 'W' } < str.length * 0.15) throw CompilerError("Code must be at weast 15% W!")
//        val stringConstants = findStrings(str)
//        for ((index, item) in stringConstants.withIndex().reversed()) {
//            str = str.replaceRange(item.first, "%str$index")
//        }
//
//        str = str.replace("//.+$".toRegex(), "")
//
//        val statements = mutableListOf<ScopeNode>()
//
//        val lines = str.split(";").flatMap { it.replace("{", "{%b").split("%b") }.flatMap { it.replace("}", "%b}").split("%b") }.map { it.dropWhile { it.isWhitespace() }.dropLastWhile { it.isWhitespace() } }
//
//        var skipTo = -1
//
//        for ((index, line) in lines.withIndex()) {
//            if (index < skipTo || line.isBlank()) continue
//            val firstWord = line.substringBefore(' ')
//
//            if (firstWord in Keyword.values().map { it.uwuified }) {
//                when (firstWord) {
//                    Keyword.FUN.uwuified -> throw CompilerError("Functions may not be nested!")
//                    in listOf(Keyword.CONTINUE.uwuified, Keyword.BREAK.uwuified) -> { TODO("break/continue") }
//                    Keyword.IF.uwuified -> { TODO("if") }
//                    Keyword.ELSE.uwuified -> { TODO("else") }
//                    in listOf(Keyword.LET.uwuified, Keyword.MUT.uwuified) -> {
//                        val expression = line.substringAfter("=").dropWhile { it.isWhitespace() }
//                        val expr = assemble(scope, phaseOneExpression(reprocessExpression(expression, stringConstants.map { it.second }, emptyList()/*TODO*/)))
//                        val variable = DefinedVariable(line.substringBefore("=").dropWhile { !it.isWhitespace() }.replace(" ", ""), expr.type)
//                        statements.add(ScopeNode.VariableSetNode(scope, variable, expr))
//                        scope.variables.add(variable)
//                    }
//                    Keyword.WHILE.uwuified -> {
//                        val subScope = Scope(scope.parents + scope, mutableListOf(), scope.imports)
//                        val range = (index + 1) until findBracedAreaEnd(lines, index)
//                        skipTo = range.last + 2
//                        val blk = parse(subScope, reprocess(lines.slice(range), stringConstants.map { it.second }))
//
//                        var count = 0
//                        var parenEnd = 0
//                        val condStart = line.removePrefix(Keyword.WHILE.uwuified).removePrefix(" ").removePrefix("(")
//                        for ((idx, c) in condStart.withIndex()) {
//                            if (c == '(') count++
//                            if (c == ')') {
//                                if (--count == 0) {
//                                    parenEnd = idx
//                                }
//                            }
//                        }
//
//                        val cond = condStart.substring(0, parenEnd + 1)
//                        val condition = assemble(scope, phaseOneExpression(cond))
//
//                        statements.add(ScopeNode.WhileLoopNode(scope, condition, blk))
//                    }
//                }
//            } else if (firstWord in scope.allVariables.map { it.name } && str.substringAfter(' ').replace(" ", "").take(1) == "=") {
//                val expression = line.substringAfter("=").dropWhile { it.isWhitespace() }
//                val expr = assemble(scope, phaseOneExpression(expression))
//                val variable = scope.allVariables.find { it.name == firstWord }!!
//                statements.add(ScopeNode.VariableSetNode(scope, variable, expr))
//            } else {
//                statements.add(ScopeNode.ExpressionNode(scope, assemble(scope, phaseOneExpression(reprocess(listOf(line), stringConstants.map { it.second }).removeSuffix(";")))))
//            }
//        }
//
//        return ScopeNode.StatementListNode(scope, statements)
//    }
//
//    sealed interface ExpressionNode {
//        val children: List<ExpressionNode>
//        val type: UwUType
//
//        fun str(indent: Int = 0): String {
//            return " ".repeat(indent) + toString() + "\n" + children.joinToString("\n") { it.str(indent + 4) }
//        }
//
//        class MethodInvokeNode(val obj: ExpressionNode, val method: UwUMethod, val args: List<ExpressionNode>) : ExpressionNode {
//            override val type: UwUType = method.returnType
//            override val children: List<ExpressionNode> = listOf(obj) + args
//
//            override fun str(indent: Int): String {
//                return " ".repeat(indent) + "${obj.str()}.${method.name}(\n" + args.joinToString("\n") { it.str(indent + 4) } + "\n" + " ".repeat(indent) + ")"
//            }
//        }
//
//        class StaticMethodInvokeNode(val cls: UwUType, val method: UwUMethod, val args: List<ExpressionNode>) : ExpressionNode {
//            override val type: UwUType = method.returnType
//            override val children: List<ExpressionNode> = args
//
//            override fun str(indent: Int): String {
//                return " ".repeat(indent) + "$cls.${method.name}(\n" + args.joinToString("\n") { it.str(indent + 4) } + "\n" + " ".repeat(indent) + ")"
//            }
//        }
//
//        class FieldGetNode(val obj: ExpressionNode, val field: UwuField) : ExpressionNode {
//            override val type: UwUType = field.type
//            override val children: List<ExpressionNode> = listOf(obj)
//
//            override fun str(indent: Int): String {
//                return " ".repeat(indent) + "$obj.${field.name}"
//            }
//        }
//
//        class ConstantNode(override val type: UwUType, val value: Any?) : ExpressionNode {
//            override val children: List<ExpressionNode> = emptyList()
//
//            override fun str(indent: Int): String {
//                return " ".repeat(indent) + "constant " + value.toString() + " type $type"
//            }
//        }
//
//        class VariableNode(val variable: DefinedVariable) : ExpressionNode {
//            override val children: List<ExpressionNode> = emptyList()
//            override val type: UwUType = variable.type
//
//
//            override fun str(indent: Int): String {
//                return " ".repeat(indent) + "variable " + variable.name + " type $type"
//            }
//        }
//    }
//
//    private fun findStrings(str: String): List<Pair<IntRange, String>> {
//        val output = mutableListOf<Pair<IntRange, String>>()
//        var stringStart = -1
//        var lastWasEscape = false
//        for ((i, c) in str.withIndex()) {
//            if (stringStart != -1) {
//                if (c == '\\') {
//                    lastWasEscape = !lastWasEscape
//                    continue
//                } else if (c == '"' && !lastWasEscape) {
//                    // todo: unescape
//                    output.add(Pair(stringStart..i, str.substring(stringStart + 1, i)))
//                    stringStart = -1
//                    lastWasEscape = false
//                } else {
//                    lastWasEscape = false
//                }
//            } else {
//                if (c == '"') {
//                    stringStart = i
//                }
//            }
//        }
//        return output
//    }
//
//    sealed interface PhaseOneToken {
//        data class PhaseOneParseOutput(
//            val tokens: List<PhaseOneToken>,
//            val stringConstants: List<String>,
//            val numberConstants: List<Pair<Number, UwUPrimitive>>
//        )
//
//        data class NameToken(val name: String) : PhaseOneToken
//        object DotToken : PhaseOneToken { override fun toString() = " . " }
//        object CommaToken : PhaseOneToken { override fun toString() = " , " }
//        object OpeningParenToken : PhaseOneToken { override fun toString() = " ( " }
//        object ClosingParenToken : PhaseOneToken { override fun toString() = " ) " }
//    }
//
//    fun phaseOneExpression(expr: String): PhaseOneToken.PhaseOneParseOutput {
//        var str = expr
//
//        val nums = "-?\\d+(\\.\\d+)?(e-?\\d+(\\.\\d+)?)?".toRegex().findAll(str).toList()
//        for ((index, item) in nums.withIndex().reversed()) {
//            str = str.replaceRange(item.range, "%num$index")
//        }
//        val numberConstants = nums.map {
//            if (it.value.contains("e") || it.value.contains(".")) it.value.toDouble() to UwUPrimitive.UwUDouble else it.value.toLong() to UwUPrimitive.UwULong
//        }
//
//        val stringConstants = findStrings(str)
//        for ((index, item) in stringConstants.withIndex().reversed()) {
//            str = str.replaceRange(item.first, "%str$index")
//        }
//
//        // TODO: boolean constants
//
//        str = str.filterNot { it.isWhitespace() }
//
//        val tokens = mutableListOf<String>()
//        var tokenStart = -1
//        for ((i, c) in str.withIndex()) {
//            if (c.isLetter() || c in '0'..'9' || c == '%') {
//                if (tokenStart == -1) tokenStart = i
//            } else {
//                if (tokenStart != -1) {
//                    tokens.add(str.substring(tokenStart, i))
//                    tokenStart = -1
//                    tokens.add(c.toString())
//                } else {
//                    tokens.add(c.toString())
//                }
//            }
//        }
//        if (tokenStart != -1) {
//            tokens.add(str.substring(tokenStart, str.length))
//        }
//
//        val parsedTokens = mutableListOf<PhaseOneToken>()
//
//        for (token in tokens) {
//            parsedTokens.add(when (token) {
//                "(" -> PhaseOneToken.OpeningParenToken
//                ")" -> PhaseOneToken.ClosingParenToken
//                "." -> PhaseOneToken.DotToken
//                "," -> PhaseOneToken.CommaToken
//                else -> PhaseOneToken.NameToken(token)
//            })
//        }
//
//        return PhaseOneToken.PhaseOneParseOutput(parsedTokens, stringConstants.map { it.second }, numberConstants)
//    }
//
//    fun assemble(scope: Scope, phaseOne: PhaseOneToken.PhaseOneParseOutput): ExpressionNode {
//        var skipTo = 0
//
//        var currentNode: ExpressionNode? = null
//
//        for ((index, token) in phaseOne.tokens.withIndex()) {
//            if (index < skipTo) continue
//
//            val lookBehind = phaseOne.tokens.getOrNull(index - 1)
//            val lookAhead = phaseOne.tokens.getOrNull(index + 1)
//
//
//            when (token) {
//                is PhaseOneToken.NameToken ->
//                    if (token.name in scope.imports.map { it.funName } && (lookBehind == null || lookBehind == PhaseOneToken.OpeningParenToken) && lookAhead == PhaseOneToken.OpeningParenToken) {
//                        val argsTokens = mutableListOf<MutableList<PhaseOneToken>>(mutableListOf())
//                        var level = 0
//                        var i = index + 1
//                        for (argToken in phaseOne.tokens.drop(index + 1)) {
//                            i++
//                            if (argToken == PhaseOneToken.OpeningParenToken) level++
//                            if (argToken == PhaseOneToken.ClosingParenToken) level--
//                            if (argToken == PhaseOneToken.CommaToken && level == 1) {
//                                argsTokens.add(mutableListOf())
//                                continue
//                            }
//                            argsTokens.last().add(argToken)
//                            if (level == 0) break
//                        }
//
//                        if (argsTokens.last().isEmpty()) argsTokens.removeLast()
//
//                        skipTo = i
//
//                        val args = argsTokens.map { assemble(scope, PhaseOneToken.PhaseOneParseOutput(it, phaseOne.stringConstants, phaseOne.numberConstants)) }
//
//                        val cls = UwUType.registry[scope.imports.find { it.funName == token.name }!!.name]!!
//                        val method = cls.methods.find { it.static && it.name == token.name && it.arguments.mapIndexed { index, pair -> pair.second == args[index].type }.all { t -> t } }!!
//
//                        require(currentNode == null)
//                        currentNode = ExpressionNode.StaticMethodInvokeNode(cls, method, args)
//                    } else if ((lookBehind == PhaseOneToken.OpeningParenToken || lookBehind == null) && (lookAhead == PhaseOneToken.CommaToken || lookAhead == PhaseOneToken.DotToken || lookAhead == PhaseOneToken.ClosingParenToken || lookAhead == null)) {
//                        // it's a variable or constant.  The only circumstance this could ever be called is when the current node is null, because the
//                        // var or const is a function argument (no parent node during parsing), or at the start of the program.
//                        require(currentNode == null)
//                        currentNode = if (token.name.startsWith("%num")) {
//                            val c = phaseOne.numberConstants[token.name.removePrefix("%num").toInt()]
//                            ExpressionNode.ConstantNode(c.second, c.first)
//                        } else if (token.name.startsWith("%str")) {
//                            val c = phaseOne.stringConstants[token.name.removePrefix("%str").toInt()]
//                            ExpressionNode.ConstantNode(UwUString, c)
//                        } else {
//                            ExpressionNode.VariableNode(scope.allVariables.find { it.name == token.name }!!)
//                        }
//                    } else if (lookBehind == PhaseOneToken.DotToken && lookAhead == PhaseOneToken.OpeningParenToken) {
//                        val argsTokens = mutableListOf<MutableList<PhaseOneToken>>(mutableListOf())
//                        var level = 0
//                        var i = index + 1
//                        for (argToken in phaseOne.tokens.drop(index + 1)) {
//                            i++
//                            if (argToken == PhaseOneToken.OpeningParenToken) level++
//                            if (argToken == PhaseOneToken.ClosingParenToken) level--
//                            if (argToken == PhaseOneToken.CommaToken && level == 1) {
//                                argsTokens.add(mutableListOf())
//                                continue
//                            }
//                            argsTokens.last().add(argToken)
//                            if (level == 0) break
//                        }
//
//                        if (argsTokens.last().isEmpty()) argsTokens.removeLast()
//
//                        skipTo = i
//
//                        val args = argsTokens.map { assemble(scope, PhaseOneToken.PhaseOneParseOutput(it, phaseOne.stringConstants, phaseOne.numberConstants)) }
//
//                        val method = currentNode!!.type.methods.find { it.name == token.name && it.arguments.mapIndexed { index, pair -> pair.second == args[index].type }.all { t -> t } }!!
//
//                        currentNode = ExpressionNode.MethodInvokeNode(currentNode, method, args)
//                    } else if (lookBehind == PhaseOneToken.DotToken && (lookAhead == PhaseOneToken.ClosingParenToken || lookAhead == PhaseOneToken.CommaToken || lookAhead == PhaseOneToken.DotToken || lookAhead == null)) {
//                        // field access
//
//                        val field = (currentNode!!.type as UwUStruct).fields.find { it.name == token.name }!!
//
//                        currentNode = ExpressionNode.FieldGetNode(currentNode, field)
//                    }
////                PhaseOneToken.CommaToken -> TODO()
////                PhaseOneToken.DotToken -> TODO()
//                // for now, no parenthesis in expressions except for function calls.
////                PhaseOneToken.OpeningParenToken -> {
////                    var level = 0
////                    for ((i, t) in phaseOne.tokens.withIndex().toList().drop(index)) {
////                        if (t == PhaseOneToken.OpeningParenToken) level++
////                        if (t == PhaseOneToken.ClosingParenToken) {
////                            if (--level == 0) {
////
////                                break
////                            }
////                        }
////                    }
////                }
////                PhaseOneToken.ClosingParenToken -> TODO()
//            }
//        }
//
//        return currentNode!!
//    }
}

fun main() {
    val parser = UwUParser()

    val inp = """
        impowt uwu.System.pwintwn;
        
        stwuct UwUBlah {
            fiewd1: UwUFoo
        }
        
        stwuct UwUFoo {
            fiewd1: Wong,
            fiewd2: Doubwe
        }
        
        fuwn UwUBlah.fwobnicate(awg: UwUFoo): Wong {
            wetuwn 12;
        }
    """.trimIndent()
//    parser.parseFile(inp)

//    val scope = UwUParser.Scope(listOf(), mutableListOf(), listOf(UwUParser.UwUImport(stdlib.System.name, "pwintwn")))
//
//    val block = parser.parse(scope, """
//        mewt nuwm = 0;
//        whiwe (nuwm.wessthan(1000)) {
//            pwintwn("Hewwo, wowwd!");
//            nuwm = nuwm.pwus(1);
//        }
//    """.trimIndent())
////    println(block)
//    val inter = UwUInterpreter()
//    val eScope = UwUInterpreter.ExecutionScope(null, mutableListOf(), mutableSetOf())
//    block.exec(eScope, inter)
//
//    UwUMem.gc()
//
//    println("This should contain only the root node")
//    println(UwUMem.tree.findAllocated())
}
