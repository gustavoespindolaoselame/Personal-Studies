Number.prototype.log = function(){console.log(this)}
Function.prototype.log = function(){console.log(this.toString())}

let r = 3

const I = a => a
r = I(3).log()

r = I(I).log()

const SELF = f => f(f)
r = SELF(I).log()

const PRI = a => b => a
r = PRI(7)(11).log()

const ULT = a => b => b
r = ULT(7)(11).log()

const TRO = f => a => b => f(b)(a)
r = TRO(ULT)(7)(11).log()

r = TRO(PRI)(11)(7).log()

const ULT2 = a => b => TRO(PRI)(a)(b)
r = ULT2(13)(20).log()

const T = PRI
const F = ULT

T.toString = () => 'Verdadeiro (PRI)'
F.toString = () => 'Falso (ULT)'

const NOT = a => a(F)(T)
r = NOT(T).log()

const AND = a => b => a(b)(F)
r = AND(T)(T).log()

const OR = a => b => a(T)(b)
r = OR(F)(T).log()

const EQ = a => b => a(b)(NOT(b))
r = EQ(F)(F).log()

const XAND = a => b => a(b)(F)
r = XAND(T)(T).log()

const XOR = a => b => a(NOT(b))(b)
r = XOR(F)(T).log()