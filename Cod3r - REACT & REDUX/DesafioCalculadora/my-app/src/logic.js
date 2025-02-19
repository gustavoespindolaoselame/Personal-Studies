export default (stringParam, callBackUpdate) => {
    const runEquation = (_) => {

        const operations = ['/','*','-','+']
        const divide = (n1, n2) => parseFloat(n1)/parseFloat(n2);
        const multiply = (n1, n2) => parseFloat(n1)*parseFloat(n2);
        const sum = (n1, n2) => parseFloat(n1)+parseFloat(n2);
        const subtract = (n1, n2) => parseFloat(n1)-parseFloat(n2);

        let parseValues = () => {

            operations.forEach(operation =>{
                if(stringParam.endsWith(operation)){
                    if(operation=='/'||operation=='*'){
                        stringParam = stringParam + '1'
                    } else {
                        stringParam = stringParam + '0'
                    }
                }
            })

            let returnParsedValues = stringParam.match(/\d+(\.\d+)?|[+\-*/]/g);
            for(let i = 0; i<returnParsedValues.length; i++){
                operations.forEach(operation => {
                    if(returnParsedValues[i]=='-'&&returnParsedValues[i-1]==operation){
                        returnParsedValues[i+1]=`${-returnParsedValues[i+1]}`;
                        returnParsedValues.splice(i,1);
                    }
                    if(returnParsedValues[0]=='-'||returnParsedValues[0]=='+'){
                        returnParsedValues.unshift('0');
                    }
                })
            }
            console.log(returnParsedValues)
            return returnParsedValues;
        };

        let parsedValues = parseValues();

        let tries = 0;
        while(parsedValues.length>1 && tries<100){
            tries++;
            let finalVal = 0;
            switch(parsedValues[1]){
                case '/':
                    finalVal = divide(parsedValues[0],parsedValues[2]);
                    parsedValues = parsedValues.slice(3);
                    parsedValues.unshift(finalVal);
                    break;
                case '*':
                    finalVal = multiply(parsedValues[0],parsedValues[2]);
                    parsedValues = parsedValues.slice(3);
                    parsedValues.unshift(finalVal);
                    break;
                case '+':
                    finalVal = sum(parsedValues[0],parsedValues[2]);
                    parsedValues = parsedValues.slice(3);
                    parsedValues.unshift(finalVal);
                    break;
                case '-':
                    finalVal = subtract(parsedValues[0],parsedValues[2]);
                    parsedValues = parsedValues.slice(3);
                    parsedValues.unshift(finalVal);
                    break;
            }
        }
        return(parsedValues);
    }
    callBackUpdate(`${runEquation()}`);
}
