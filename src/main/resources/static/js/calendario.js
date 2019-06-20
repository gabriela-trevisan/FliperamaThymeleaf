
const formatarData = dataBruta =>{
    return `${String(dataBruta.getMonth()+1).padStart(2, '0')}/${dataBruta.getFullYear()}`
}
const montadorData = dataFormatada =>{
    return new Date(dataFormatada.substring(3, 8), dataFormatada.substring(0,2) -1)
}

const getTitulo =() =>{
    return titulo = document.querySelector('#calendario #titulo')

}

const montaTitulo = () =>{
    let dataHoje = new Date()

    let titulo = getTitulo()
    console.log(String(1).padStart(2, '0'))

    titulo.innerText = formatarData(dataHoje)
}


const montarCalendario = dataInput => {
    let data = dataInput
    let tabela = document.querySelector("#calendario tbody")
    let valoresSemana = document.querySelectorAll(" #dsemana th")
    let mes = data.getMonth()
    for (let j = 0; j < 6; j++) {

        if (!j) {
            let tr = document.createElement("tr")
            tabela.appendChild(tr)
            let diaSemana = data.getDay()

            for (let i = 0; i < 7; i++) {

                if (data.getDay() != valoresSemana[i].getAttribute('value')) {
                    data.setDate(data.getDate() - data.getDay())
                    let dia = data.getDate()
                    let td = document.createElement("td")
                    td.setAttribute('style', "opacity: 0.5")
                    td.innerText = dia
                    tr.appendChild(td)
                    data.setDate(data.getDate() + 1)

                } else {
                    let dia = data.getDate()
                    let td = document.createElement("td")

                    if (dia > 7) {
                        td.setAttribute('style', "opacity: 0.5")
                        td.innerText = dia
                    } else {
                        let link = document.createElement("a")
                        link.innerText = dia
                        link.setAttribute('href', `/agendamento?data=${data.toISOString().substring(0,16)}`)
                        td.appendChild(link)
                    }
                    tr.appendChild(td)

                    data.setDate(data.getDate() + 1)
                }
            }
        } else {
            let tr = document.createElement("tr")
            tabela.appendChild(tr)

            for (let i = 0; i < 7; i++) {
                if (data.getMonth() > mes) {
                    let dia = data.getDate()
                    let td = document.createElement("td")
                    td.innerText = dia
                    td.setAttribute('style', 'opacity: 0.5')
                    tr.appendChild(td)
                    data.setDate(data.getDate() + 1)
                } else {
                    let dia = data.getDate()
                    let td = document.createElement("td")
                    let link = document.createElement("a")
                    link.innerText = dia
                    link.setAttribute('href', `/agendamento?data=${data.toISOString().substring(0,16)}`)
                    td.appendChild(link)
                    if (data.toLocaleDateString() == new Date().toLocaleDateString()) {
                        td.setAttribute('class', 'btn-primary')
                        link.setAttribute('style', 'color: #000')
                    }
                    tr.appendChild(td)
                    data.setDate(data.getDate() + 1)

                }
            }
        }

    }
}

const montaMesAtual =  () =>{

    let titulo = getTitulo().textContent
    //console.log(titulo.substring(3,8))

    montarCalendario(montadorData(titulo))


}

const limpaCalendario = () =>{
    let table = document.querySelector('table')
    let corpo = document.querySelector('tbody')

    table.removeChild(corpo)

    let body = document.createElement('tbody')
    table.appendChild(body)

    // montarCalendario()
}


const proximoMes =() =>{
    let titulo = getTitulo()
    let data = montadorData(titulo.textContent)
    data.setMonth(data.getMonth()+1)
    limpaCalendario()
    titulo.innerText = formatarData(data)
    montarCalendario(data)

}

const mesAnterior = () =>{
    let titulo = getTitulo()
    let data = montadorData(titulo.textContent)
    data.setMonth(data.getMonth()-1)
    limpaCalendario()
    titulo.innerText = formatarData(data)
    montarCalendario(data)

}








