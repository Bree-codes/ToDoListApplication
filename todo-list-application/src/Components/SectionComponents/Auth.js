export const Auth = () => {
    const isLoggedIn = sessionStorage.getItem('isLoggedIn');

    return isLoggedIn === "true";
}