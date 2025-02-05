#Sintaxe lambda calculus

λa.x

λ = função
a = parâmetro
x = corpo

<exp>::=<var> (expressão é uma variável)
<exp>::=<exp><exp> (expressão é um parâmetro) aplicação
<exp>::=λ<var><exp> (expressão é uma função) abstração
<exp>::=(<exp>) (expressões são mais de uma)


#ABSTRAÇÃO

Lambda calculus:    λa.b
Javascript:         a=>b

Lambda calculus:    λa.b x
Javascript:         a=>b(x)

Lambda calculus:    λa.(b x)
Javascript:         a=>b((x))

Lambda calculus:    (λa.b) x
Javascript:         (a=>b)(x)

Lambda calculus:    λa.λb.a
Javascript:         a => b => a



#APLICAÇÃO

Lambda calculus:    F a
Javascript:         F(a)

Lambda calculus:    F a b
Javascript:         F(a)(b)

Lambda calculus:    (F a) b
Javascript:         (F(a))(b)

Lambda calculus:    F (a b)
Javascript:         F(a(b))