import './../Styles/homestles.css'
import HomePageImages from "../SectionComponents/HomePageImages.jsx";
import HomeHeader from "../SectionComponents/HomeHeader.jsx";

const Home = () => {
    return (
        <div  className={'home'}>
            <HomeHeader />
            <HomePageImages />
        </div>
    );
};

export default Home;