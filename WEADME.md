# kiww me pwease

## UwuWang
### Vewsion Zewo Point Wum
UwuWang is a WIP dynamicawwy typed wanguage
wif a mawk awnd sweep gawbage cowwectow 
and stwucts.  The wefewence intewpwetew 
is wittem in kotwin.

#### Wesewved keywowds (* - not yet impwemented):
- fuwn
- wetuwn
- bweak *
- continuwue *
- if
- ewse *
- wet
- mewt
- stawtic
- whiwe

#### Builtin types:
- Int
- Stwing
- Doubwe
- Chaw
- Awway

#### Future ideas:
- Bracket access
- Private access
- Namespaces
- 
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
