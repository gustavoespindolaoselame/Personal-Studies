export default props => {
    const { min, max } = props;
    const random = Math.round((Math.random() * (max-min)) + min)
    return <>
        Max: {max}<br/>
        Min: {min}<br/>
        Random: {random}
    </>
}