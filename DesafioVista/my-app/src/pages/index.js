import Navbar from "./navbar";
import TopSec from "./sections/topSec";
import JoelSec from "./sections/joelSec";
import Footer from "./footer";
import './style.css'
import LakewoodSec from "./sections/lakewoodSec";
import BottomAnnouncement from "./bottomAnnouncement";
import ServiceTimeSec from "./sections/serviceTimeSec";
import WhatsHappeningSec from "./sections/whatsHappeningSec";
import LatestMsgSec from "./sections/latestMsgSec";
import HomecomingSec from "./sections/homecomingSec";
import StayConnectedSec from "./sections/stayConnectedSec";
import GetTheAppSec from "./sections/getTheAppSec";

export default function Home() {
  return (
    <>
      <Navbar></Navbar>
      <div className="body">
        <TopSec></TopSec>
        <JoelSec></JoelSec>
        <LakewoodSec></LakewoodSec>
        <ServiceTimeSec></ServiceTimeSec>
        <WhatsHappeningSec></WhatsHappeningSec>
        <LatestMsgSec></LatestMsgSec>
        <HomecomingSec></HomecomingSec>
        <StayConnectedSec></StayConnectedSec>
        <GetTheAppSec></GetTheAppSec>
      </div>
      <BottomAnnouncement></BottomAnnouncement>
      <Footer></Footer>
    </>
  );
}
