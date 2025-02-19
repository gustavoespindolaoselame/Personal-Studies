export default (stringParam, callBackUpdate) => {
    const runEquation = (_) => {
        const divide = (n1, n2) => parseFloat(n1)/parseFloat(n2)
        const multiply = (n1, n2) => parseFloat(n1)*parseFloat(n2)
        const sum = (n1, n2) => parseFloat(n1)+parseFloat(n2)
        const subtract = (n1, n2) => parseFloat(n1)-parseFloat(n2)
        let parsedValues = stringParam.match(/\d+(\.\d+)?|[+\-*/]/g);

        while(parsedValues.length>1){
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
