
## Rotas da Aplicação


 ### 1. POST /farms

<details>
  <summary> Cria uma nova fazenda a partir dos dados recebidos </summary> </br>


| Parâmetro   | Tipo       |
| :---------- | :--------- |
| `name` | `string` | 
| `size` | `number` | 


  <summary>🔍 Formato/exemplo de requisição e resposta</summary><br />

Exemplo de requisição:
```json
{
  "name": "Fazendinha",
  "size": 5
}
```

Exemplo de resposta:

```json
{
  "id": 1,
  "name": "Fazendinha",
  "size": 5
}
```


</details>



### 2. GET /farms
<details><summary>Retorna uma lista com todas as fazendas
</summary><br />

  <summary>🔍 Formato/exemplo de resposta</summary><br />

Exemplo de resposta:

```json
[
  {
    "id": 1,
    "name": "Fazendinha",
    "size": 5.0
  },
  {
    "id": 2,
    "name": "Fazenda do Júlio",
    "size": 2.5
  }
]
```

</details>

### 3. GET /farms/{id}

<details><summary>Retorna uma fazenda com o id passado por parâmetro
</summary><br />

<summary>🔍 Formato/exemplo de resposta</summary><br />

Exemplo de resposta para a rota `/farms/3` (supondo que exista uma fazenda com `id = 3`):

```json
{
  "id": 3,
  "name": "My Cabbages!",
  "size": 3.49
}
```

 - Caso não exista uma fazenda com esse `id`, a rota retorna o status HTTP 404 com a
      mensagem `Fazenda não encontrada!` no corpo da resposta.
</details>

 ### 4. POST /farms/{farmId}/crops

<details>
  <summary> Cria uma plantação a partir dos dados recebidos, associada à fazenda com o ID recebido </summary> </br>


| Parâmetro   | Tipo       |
| :---------- | :--------- |
| `name` | `string` | 
| `plantedArea` | `number` | 


  <summary>🔍 Formato/exemplo de requisição e resposta</summary><br />
  Exemplo de requisição na rota `/farms/1/crops` (supondo que exista uma fazenda com `id = 1`): 

```json
{
  "name": "Couve-flor",
  "plantedArea": 5.43
}
```

Exemplo de resposta:

```json
{
  "id": 1,
  "name": "Couve-flor",
  "plantedArea": 5.43,
  "farmId": 1
}
```
- Note que o `id` da resposta se refere à plantação, e que o da fazenda está em `farmId`.
- Caso não exista uma fazenda com o `id` passado, a rota retorna o status HTTP 404 com a
      mensagem `Fazenda não encontrada!` no corpo da resposta.


</details>

### 5. GET /farms/{farmId}/crops

<details><summary>Retorna uma lista de plantações de uma fazenda.
</summary><br />

<summary>🔍 Formato/exemplo de resposta</summary><br />

Exemplo de resposta para a rota `/farms/1/crops` (supondo que exista uma fazenda com `id = 1`):

```json
[
  {
    "id": 1,
    "name": "Couve-flor",
    "plantedArea": 5.43,
    "farmId": 1
  },
  {
    "id": 2,
    "name": "Alface",
    "plantedArea": 21.3,
    "farmId": 1
  }
]
```

 - Caso não exista uma fazenda com esse `id`, a rota retorna o status HTTP 404 com a
      mensagem `Fazenda não encontrada!` no corpo da resposta.
</details>

### 6. GET /crops

<details><summary>Lista todas as plantações cadastradas
</summary><br />

<summary>🔍 Formato/exemplo de resposta</summary><br />


```json
[
  {
    "id": 1,
    "name": "Couve-flor",
    "plantedArea": 5.43,
    "farmId": 1
  },
  {
    "id": 2,
    "name": "Alface",
    "plantedArea": 21.3,
    "farmId": 1
  },
  {
    "id": 3,
    "name": "Tomate",
    "plantedArea": 1.9,
    "farmId": 2
  }
]
```

</details>

### 7. GET /crops/{id}

<details><summary>Retorna as informações de uma plantação com o id passado por parâmetro
</summary><br />

<summary>🔍 Formato/exemplo de resposta</summary><br />


Exemplo de resposta para a rota `/crops/3` (supondo que exista uma plantação com `id = 3`:

```json
{
  "id": 3,
  "name": "Tomate",
  "plantedArea": 1.9,
  "farmId": 2
}
```

- Caso não exista uma plantação com o `id` passado, a rota deve retornar o status HTTP 404 com a
      mensagem `Plantação não encontrada!` no corpo da resposta.

</details>

 ### 8. POST /fertilizers

<details>
  <summary> Cria um novo fertilizante a partir dos dados recebidos </summary> </br>


| Parâmetro   | Tipo       |
| :---------- | :--------- |
| `name` | `string` | 
| `brand` | `string` | 
| `composition` | `string` | 



  <summary>🔍 Formato/exemplo de requisição e resposta</summary><br />

Exemplo de requisição:
```json
{
  "name": "Compostagem",
  "brand": "Feita em casa",
  "composition": "Restos de alimentos"
}
```

Exemplo de resposta:

```json
{
  "id": 1,
  "name": "Compostagem",
  "brand": "Feita em casa",
  "composition": "Restos de alimentos"
}
```


</details>

### 9. GET /fertilizers

<details><summary>Lista todas os fertilizantes cadastrados
</summary><br />

<summary>🔍 Formato/exemplo de resposta</summary><br />

```json
[
  {
    "id": 1,
    "name": "Compostagem",
    "brand": "Feita em casa",
    "composition": "Restos de alimentos"
  },
  {
    "id": 2,
    "name": "Húmus",
    "brand": "Feito pelas minhocas",
    "composition": "Muitos nutrientes"
  },
  {
    "id": 3,
    "name": "Adubo",
    "brand": "Feito pelas vaquinhas",
    "composition": "Esterco"
  }
]
```

</details>

### 10. GET /fertilizers/{id}

<details><summary>Retorna as informações de um fertilizante com o id passado por parâmetro
</summary><br />

<summary>🔍 Formato/exemplo de resposta</summary><br />

```json
{
  "id": 3,
  "name": "Adubo",
  "brand": "Feito pelas vaquinhas",
  "composition": "Esterco"
}
```
 - caso não exista um fertilizante com o `id` passado, a rota deve retornar o status HTTP 404 com a
      mensagem `Fertilizante não encontrado!` no corpo da resposta.

</details>

### 11. POST /crops/{cropId}/fertilizers/{fertilizerId}

<details><summary>Faz a associação entre uma plantação e um fertilizante
</summary><br />

- Recebe tanto o `id` da plantação quanto o `id` do fertilizante pelo caminho da rota
- Caso não exista uma plantação com o `id` recebido, a rota deve retornar o status HTTP 404 com a mensagem `Plantação não encontrada!` no corpo da resposta.
- Caso não exista um fertilizante com o `id` recebido, a rota deve retornar o status HTTP 404 com a mensagem `Fertilizante não encontrado!` no corpo da resposta.

<summary>🔍 Formato/exemplo de requisição e resposta</summary><br />

Exemplo de resposta para a rota `/crops/1/fertilizers/2` (supondo que exista uma plantação com `id = 1` e um fertilizante com `id = 2`):

```text
Fertilizante e plantação associados com sucesso!
```

</details>

### 12. GET /crops/{cropId}/fertilizers

<details>
  <summary>Lista os fertilizantes associados a uma plantação</summary><br />

  <summary>🔍 Formato/exemplo de resposta</summary><br />

Exemplo de resposta para a rota `/crops/2/fertilizers` (supondo que exista uma plantação com `id = 2`):

```json
[
  {
    "id": 2,
    "name": "Húmus",
    "brand": "Feito pelas minhocas",
    "composition": "Muitos nutrientes"
  },
  {
    "id": 3,
    "name": "Adubo",
    "brand": "Feito pelas vaquinhas",
    "composition": "Esterco"
  }
]
```
- caso não exista uma plantação com o `id` recebido, a rota deve retornar o status HTTP 404 com a mensagem `Plantação não encontrada!` no corpo da resposta.

</details>

### 13. POST /persons

<details>
  <summary>Salva as pessoas no banco</summary><br />

| Parâmetro   | Tipo       |
| :---------- | :--------- |
| `username` | `string` | 
| `password` | `string` | 
| `role` | `string` | 

  <summary>🔍 Formato/exemplo de requisição e resposta</summary><br />

Exemplo de requisição na rota POST `/persons`:

```json
{
  "username": "zerocool",
  "password": "senhasecreta",
  "role": "ADMIN"
}
```

Exemplo de resposta:

```json
{
  "id": 1,
  "username": "zerocool",
  "role": "ADMIN"
}
```

</details>


## Acesso às rotas
Caso a pessoa não tenha as permissões corretas é retornado status 403<br />

### Rota GET /farms
 - O acesso da rota /farms é liberada para todas as pessoas.<br />

### Rota GET /crops
 - O acesso da rota /crops é liberada apenas para pessoas autenticadas com a role MANAGER ou ADMIN<br />

### Rota GET /fertilizers
 - O acesso da rota /fertilizers é liberada apenas para pessoas autenticadas com a role ADMIN<br />




