import '../Styles/home.css'
import HomePageImages from "../SectionComponents/HomePageImages.jsx";
import HomeHeader from "../SectionComponents/HomeHeader.jsx";
import HomeFooter from "../SectionComponents/HomeFooter.jsx";

const Home = () => {
    return (
        <div  className={'home'}>
            <HomeHeader />
            <HomePageImages />
            <HomeFooter />
        </div>
    );
};

export default Home;