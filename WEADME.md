# kiww me pwease

## UwuWang
### Vewsion Zewo Point Wum
UwuWang is a WIP stwict typed wanguage
wif a mawk awnd sweep gawbage cowwectow 
and stwucts.  The wefewence intewpwetew 
is wittem in kotwin.

#### Wesewved keywowds:
- fuwn
- wetuwn
- bweak
- continuwue
- if
- ewse
- wet
- mewt
- stawtic
- whiwe

#### Builtin types:
- Int
- Stwing
- Doubwe
- Chaw (unfinished)
- Awway

#### Future ideas:
- Infix notation parsing (for now .plus(), .minus(), etc)
- Bracket access
- Private access
- Namespaces

#### Expression parse precedence:
1. Parenthesis
2. Field gets
3. Method invocations

```
stawtic fuwn main(awgs: Awway<Stwing>) {
    pwintwn(awgs.get(0));
    if (awgs.get(0) == "uwu") {
        pwintwn("iwjfioewoifew");
    }
}

stwuct MyType {
    field1: Type,
    field2: Type,
    field3: Type
}

// comment
stawtic fuwn funName(arg1: Type, arg2: Type): ReturnType { // : ReturnType optional, default is Void
    funCall(arg1, arg2);
    wet name = expression;
    mewt Stwing str = "string constant";
    mewt Doubwe integer = 12;
    wet double = 12.0; // 12e0 also acceptable

    if (expression) {
        code;
    } ewse if (expression) {
        code;
    } ewse {
        code;
    }

    whiwe (expression) {
        bweak;
        continuwue;
    }
    wetuwn expression;
}

```
